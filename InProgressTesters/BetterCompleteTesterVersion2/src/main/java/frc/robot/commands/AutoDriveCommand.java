// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.AutonStartPosition;
import frc.robot.Constants.ClawDirection;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoDriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem driveSubsystem;
  private final ElevatorSubsystem elevatorSubsystem;
  private final ClawSubsystem clawSubsystem;
  private Timer timer;
  private double driveSpeed;
  private double turnSpeed;
  private double elevatorSpeed;
  private ClawCommand outClawCommand;
  private ClawCommand inClawCommand;
  private AutonStartPosition autonStartPosition;
  private double multiplier = 1;
  private double turnAmount = 0;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoDriveCommand(DriveSubsystem driveSubsystem, ElevatorSubsystem elevatorSubsystem, ClawSubsystem clawSubsystem, AutonStartPosition autonStartPosition) {
    this.driveSubsystem = driveSubsystem;
    this.elevatorSubsystem = elevatorSubsystem;  
    this.clawSubsystem = clawSubsystem;
    this.autonStartPosition = autonStartPosition;
    outClawCommand = new ClawCommand(clawSubsystem, ClawDirection.OUT);
    inClawCommand = new ClawCommand(clawSubsystem, ClawDirection.IN);
    // Use addRequirements() here to declare subsystem dependencies.
    timer = new Timer();
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    // we need to define direction AND turn amount through enum of auton start position

    // direction of turn
    if (autonStartPosition == AutonStartPosition.RED_SHORT || autonStartPosition == AutonStartPosition.BLUE_LONG)
    {
      multiplier = 1;
    }
    else if (autonStartPosition == AutonStartPosition.RED_LONG || autonStartPosition == AutonStartPosition.BLUE_SHORT)
    {
      multiplier = -1;
    }

    // amount of turn
    if (autonStartPosition == AutonStartPosition.RED_LONG || autonStartPosition == AutonStartPosition.BLUE_LONG)
    {
      turnAmount = 0.45;
    }
    else if (autonStartPosition == AutonStartPosition.RED_SHORT || autonStartPosition == AutonStartPosition.BLUE_SHORT)
    {
      turnAmount = 0.4;
    }
    
    timer.reset();
    timer.start();
    
    DriveSubsystem.drive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSpeed = 0;
    elevatorSpeed = 0;
    turnSpeed = 0;

    
    if(timer.get() > 2.4 && timer.get() < 5.9) // close claw and bring elevator up 5.9 og 1.5 diff -2 mid
    {
      elevatorSpeed = -0.4;
      ElevatorSubsystem.runElevator(elevatorSpeed);
    }
    
    else if(timer.get() >= 5.9 && timer.get() < 6.2) // drive forward 0.3
    {
      driveSpeed = -0.5;
      DriveSubsystem.drive(driveSpeed, 0);
    }
    
    else if(timer.get() >= 6.2 && timer.get() < 6.6) // open claw to release cube 0.4
    {
      outClawCommand.schedule();
    }
    
    else if(timer.get() >= 6.6 && timer.get() < 6.9) // drive backward a little so the claw doesn't hit the cube homes 0.3
    {
      outClawCommand.cancel(); 
      driveSpeed = 0.4;
      DriveSubsystem.drive(driveSpeed, 0);
    }
    else if (timer.get() >= 6.9 && timer.get() < 10.4) // bring elevator down 3.5
    {
      elevatorSpeed = 0.4;
      ElevatorSubsystem.runElevator(elevatorSpeed);
    }
    
    else if(timer.get() >= 10.4 && timer.get() < 10.75) // turn one way depending on the starting position 0.35
    {
      turnSpeed = multiplier * turnAmount;
      DriveSubsystem.drive(0, turnSpeed);
    }
     
    else if(timer.get() >= 10.75 && timer.get() < 14.4) // move backwards to hit the red line 3.65
    {
      // end time was 14.75, we are changing it to 14.4
      driveSpeed = 0.55;
      DriveSubsystem.drive(driveSpeed, 0);
    }
    
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSubsystem.drive(0, 0);
    ElevatorSubsystem.runElevator(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
