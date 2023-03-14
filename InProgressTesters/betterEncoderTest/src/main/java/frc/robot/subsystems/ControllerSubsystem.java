// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants;

public class ControllerSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public static Joystick controller;
  public static POVButton pivotUpButton;
  public static POVButton pivotDownButton;

  public ControllerSubsystem() {
    controller = new Joystick(Constants.CONTROLLER1_ID);
    pivotUpButton = new POVButton(controller, Constants.PIVOT_UP_DIRECTION);
    pivotDownButton = new POVButton(controller, Constants.PIVOT_DOWN_DIRECTION);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static Joystick getController() {
    return controller;
  }

  public static POVButton getPivotUpButton() {
    return pivotUpButton;
  }

  public static POVButton getPivotDownButton() {
    return pivotDownButton;
  }
}
