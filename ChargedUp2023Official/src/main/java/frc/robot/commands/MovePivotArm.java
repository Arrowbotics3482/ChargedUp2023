// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Constants.PivotDirection;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PivotArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class MovePivotArm extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  // private final ExampleSubsystem m_subsystem;
  private final PivotArmSubsystem pivotArmSubsystem;
  private final int directionMultiplier;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MovePivotArm(PivotArmSubsystem pivotArmSubsystem, PivotDirection pivotDirection) {
    this.pivotArmSubsystem = pivotArmSubsystem;

    if (pivotDirection == PivotDirection.UP)
    {
      directionMultiplier = 1;
    }
    else
    {
      directionMultiplier = -1;
    }

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pivotArmSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    PivotArmSubsystem.getPivotArmMotor().set(directionMultiplier * Constants.PIVOT_ARM_SPEED);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    PivotArmSubsystem.getPivotArmMotor().set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
