// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.ElevatorAdjust;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class CorrectRobotY extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final LimelightSubsystem limelightSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public CorrectRobotY(LimelightSubsystem limelightSubsystem) {
    this.limelightSubsystem = limelightSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(limelightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ElevatorSubsystem.switchElevatorAdjust();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /* 
    if(Math.abs(LimelightHelpers.getTY("limelight")) < Constants.LIMELIGHT_Y_THRESHOLD)
    {
      ElevatorSubsystem.runElevator(0);
    }
    */
    if(LimelightHelpers.getTY("limelight") > 0)
    {
      ElevatorSubsystem.runElevator(-0.3); // elevator goes down
    }
    else if(LimelightHelpers.getTY("limelight") < 0)
    {
      ElevatorSubsystem.runElevator(0.3); // elevator goes up
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ElevatorSubsystem.runElevator(0);
    ElevatorSubsystem.switchElevatorAdjust();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
