// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.AutonStartPosition;
import frc.robot.Constants.ClawPosition;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PneumaticClawSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoDriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem driveSubsystem;
  private final ElevatorSubsystem elevatorSubsystem;
  private final PneumaticClawSubsystem pneumaticClawSubsystem;
  private Timer timer;
  private double driveSpeed;
  private double turnSpeed;
  private double elevatorSpeed;
  private ClawCommand closeClawCommand;
  private ClawCommand openClawCommand;
  private AutonStartPosition autonStartPosition;
  private double multiplier = 1;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoDriveCommand(DriveSubsystem driveSubsystem, ElevatorSubsystem elevatorSubsystem, PneumaticClawSubsystem pneumaticClawSubsystem, AutonStartPosition autonStartPosition) {
    this.driveSubsystem = driveSubsystem;
    this.elevatorSubsystem = elevatorSubsystem; 
    this.pneumaticClawSubsystem = pneumaticClawSubsystem;
    this.autonStartPosition = autonStartPosition;
    closeClawCommand = new ClawCommand(pneumaticClawSubsystem, ClawPosition.CLOSE);
    openClawCommand = new ClawCommand(pneumaticClawSubsystem, ClawPosition.OPEN);
    // Use addRequirements() here to declare subsystem dependencies.
    timer = new Timer();
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (autonStartPosition == AutonStartPosition.RED_SHORT_OR_BLUE_LONG)
    {
      multiplier = -1;
    }
    else if (autonStartPosition == AutonStartPosition.RED_SHORT_OR_BLUE_LONG)
    {
      multiplier = 1;
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

    if(timer.get() < 3.5) // close claw and bring elevator up
    {
      closeClawCommand.schedule();

      elevatorSpeed = -0.4;
      ElevatorSubsystem.runElevator(elevatorSpeed);
    }
    else if(timer.get() < 3.8) // drive forward
    {
      driveSpeed = -0.5;
      DriveSubsystem.drive(driveSpeed, 0);
    }
    
    else if(timer.get() < 5) // open claw to release cube
    {
      openClawCommand.schedule();
    }
    /*
    else if(timer.get() < 5) // drive backward a little so the claw doesn't hit the cube homes
    {
      openClawCommand.cancel();
      driveSpeed = -0.4;
      DriveSubsystem.drive(driveSpeed, 0);
    }
    else if (timer.get() < 8.5) // bring elevator down
    {
      elevatorSpeed = 0.4;
      ElevatorSubsystem.runElevator(elevatorSpeed);
    }
    
    else if(timer.get() < 11.5) // move backwards to hit the red line
    {
      driveSpeed = -0.3;
      DriveSubsystem.drive(driveSpeed, 0);
    }
    */

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
