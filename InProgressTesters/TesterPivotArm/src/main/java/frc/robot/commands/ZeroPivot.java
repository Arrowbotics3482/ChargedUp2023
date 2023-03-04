// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PivotArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ZeroPivot extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final PivotArmSubsystem pivotArmSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ZeroPivot(PivotArmSubsystem pivotArmSubsystem) {
    this.pivotArmSubsystem = pivotArmSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pivotArmSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(pivotArmSubsystem.getConstantDirection()){
      pivotArmSubsystem.getNEO().set(-(pivotArmSubsystem.getConstantDistance()/Constants.ENCODER_PIVOT_DIVISOR));
    }
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    pivotArmSubsystem.getEncoder().reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
