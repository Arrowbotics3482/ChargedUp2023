// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Constants.ClawAdjust;
import frc.robot.Constants.ClawDirection;
import frc.robot.subsystems.ClawSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ClawCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ClawSubsystem clawSubsystem;
  private ClawDirection clawDirection;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ClawCommand(ClawSubsystem clawSubsystem, ClawDirection clawDirection) {
    this.clawSubsystem = clawSubsystem;
    this.clawDirection = clawDirection;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(clawSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ClawSubsystem.switchClawAdjust();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(clawDirection == Constants.ClawDirection.IN){
      ClawSubsystem.getClawMotor().set(Constants.CLAW_MOTOR_SPEED);
    }
    else if(clawDirection == Constants.ClawDirection.OUT){
      ClawSubsystem.getClawMotor().set(-1* Constants.CLAW_MOTOR_SPEED);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ClawSubsystem.getClawMotor().set(0);
    ClawSubsystem.switchClawAdjust();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
