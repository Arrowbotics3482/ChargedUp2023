// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.LimelightHelpers;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class CorrectRobotX extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final LimelightSubsystem limelightSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public CorrectRobotX(LimelightSubsystem limelightSubsystem) {
    this.limelightSubsystem = limelightSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(limelightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    DriveSubsystem.switchDriveAdjust();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    // is this like periodic?
    if(Math.abs(LimelightHelpers.getTX("limelight")) < Constants.LIMELIGHT_X_THRESHOLD)
    {
      DriveSubsystem.drive(0, 0);
    }
    else if(LimelightHelpers.getTX("limelight") > 0)
    {
      DriveSubsystem.drive(0, 0.4); // turn, fb
    }
    else if(LimelightHelpers.getTX("limelight") < 0)
    {
      DriveSubsystem.drive(0 , -0.4);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    // may have to reset the drive()
    DriveSubsystem.drive(0, 0);
    DriveSubsystem.switchDriveAdjust();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
