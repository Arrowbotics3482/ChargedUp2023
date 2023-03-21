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
public class PivotArmCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final PivotArmSubsystem pivotArmSubsystem;
  private static PivotDirection pivotDirection;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public PivotArmCommand(PivotArmSubsystem pivotArmSubsystem, PivotDirection pivotDirection) {
    this.pivotArmSubsystem = pivotArmSubsystem;
    this.pivotDirection = pivotDirection;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pivotArmSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(pivotDirection == PivotDirection.UP)
    {
      PivotArmSubsystem.getPivotMotor().set(-1 * Constants.PIVOT_MOTOR_SPEED);
    }
    else if(pivotDirection == PivotDirection.DOWN)
    {
      PivotArmSubsystem.getPivotMotor().set(Constants.PIVOT_MOTOR_SPEED);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(pivotDirection == PivotDirection.UP)
    {
      System.out.println("up");
    }
    else if(pivotDirection == PivotDirection.DOWN)
    {
      System.out.println("down");
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    PivotArmSubsystem.getPivotMotor().set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
