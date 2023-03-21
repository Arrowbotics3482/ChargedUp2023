// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClawPosition;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PneumaticClawSubsystem;

/** An example command that uses an example subsystem. */
public class ClawCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  // private final ExampleSubsystem m_subsystem;
  private final PneumaticClawSubsystem pneumaticClawSubsystem;
  private ClawPosition clawPosition;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ClawCommand(PneumaticClawSubsystem pneumaticClawSubsystem, ClawPosition clawPosition) {
    this.pneumaticClawSubsystem = pneumaticClawSubsystem;
    this.clawPosition = clawPosition;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pneumaticClawSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(clawPosition == ClawPosition.OPEN)
    {
      PneumaticClawSubsystem.getPiston1().set(Value.kForward);
      PneumaticClawSubsystem.getPiston2().set(Value.kForward);
      PneumaticClawSubsystem.setClawState(ClawPosition.OPEN);
      System.out.println("open");
    }
    if (clawPosition == ClawPosition.CLOSE)
    {
      PneumaticClawSubsystem.getPiston1().set(Value.kReverse);
      PneumaticClawSubsystem.getPiston2().set(Value.kReverse);
      PneumaticClawSubsystem.setClawState(ClawPosition.CLOSE);
      System.out.println("close");
    }
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //PneumaticClawSubsystem.getPiston1().set(Value.kOff);
    //PneumaticClawSubsystem.getPiston2().set(Value.kOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
