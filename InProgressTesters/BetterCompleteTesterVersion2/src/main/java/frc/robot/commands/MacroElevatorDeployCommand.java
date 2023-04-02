// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class MacroElevatorDeployCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ElevatorSubsystem elevatorSubsystem;
  private double elevatorMacroSpeed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MacroElevatorDeployCommand(ElevatorSubsystem elevatorSubsystem) {
    this.elevatorSubsystem = elevatorSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(elevatorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevatorMacroSpeed = 0;
    if(ElevatorSubsystem.getDistSens().getRange() < Constants.ELEVATOR_MACRO_DISTANCE - Constants.ELEVATOR_MACRO_THRESHOLD)
    {
      elevatorMacroSpeed = -0.4; // moves up
      ElevatorSubsystem.runElevator(elevatorMacroSpeed);
    }
    else if(ElevatorSubsystem.getDistSens().getRange() > Constants.ELEVATOR_MACRO_DISTANCE + Constants.ELEVATOR_MACRO_THRESHOLD)
    {
      elevatorMacroSpeed = 0.4; // move down
      ElevatorSubsystem.runElevator(elevatorMacroSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ElevatorSubsystem.runElevator(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
