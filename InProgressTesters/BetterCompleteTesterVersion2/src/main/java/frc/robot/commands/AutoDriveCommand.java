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
  private ClawCommand clawCommand;
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
    clawCommand = new ClawCommand(pneumaticClawSubsystem, ClawPosition.OPEN);
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

    if(timer.get() < 4.8) // close claw and bring elevator up
    {
      new ClawCommand(pneumaticClawSubsystem, ClawPosition.CLOSE);

      elevatorSpeed = -0.3;
      ElevatorSubsystem.runElevator(elevatorSpeed);
    }
    else if(timer.get() < 5.1) // drive forward
    {
      driveSpeed = 0.3;
      DriveSubsystem.drive(driveSpeed, 0);
    }
    else if(timer.get() < 5.3) // open claw to release cube
    {
      new ClawCommand(pneumaticClawSubsystem, ClawPosition.OPEN);
    }
    else if(timer.get() < 5.8) // drive backward
    {
      driveSpeed = -0.3;
      DriveSubsystem.drive(driveSpeed, 0);
    }
    else if (timer.get() < 6.1) // bring elevator down
    {
      elevatorSpeed = 0.3;
      ElevatorSubsystem.runElevator(elevatorSpeed);
    }
    else if(timer.get() < 6.4) // turn robot a few degrees to the left
    {
      turnSpeed = -0.3 * multiplier;
      DriveSubsystem.drive(0, turnSpeed);
    }
    else if(timer.get() < 7) // move backwards to hit the red line
    {
      driveSpeed = -0.3;
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
