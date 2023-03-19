// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants;

public class ControllerSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private static Joystick controller1;
  private static Joystick controller2;
  private static POVButton pivotUpButton;
  private static POVButton pivotDownButton;
  private static JoystickButton clawOpenButton;
  private static JoystickButton clawCloseButton;
  private static JoystickButton correctChassisOrientationButton;
  private static JoystickButton correctElevatorOrientationButton;

  public ControllerSubsystem() {
    controller1 = new Joystick(Constants.CONTROLLER1_ID); 
    controller2 = new Joystick(Constants.CONTROLLER2_ID);

    pivotUpButton = new POVButton(controller2, 0);
    pivotDownButton = new POVButton(controller2, 180);

    clawOpenButton = new JoystickButton(controller2, 1);
    clawCloseButton = new JoystickButton(controller2, 2);

    correctChassisOrientationButton = new JoystickButton(controller2, 3);
    correctElevatorOrientationButton = new JoystickButton(controller2, 4);


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

  public static Joystick getController1() {
    return controller1;
  }

  public static Joystick getController2() {
    return controller2;
  }

  public static POVButton getPivotUpButton() {
    return pivotUpButton;
  }

  public static POVButton getPivotDownButton() {
    return pivotDownButton;
  }

  public static JoystickButton getClawOpenButton() {
    return clawOpenButton;
  }

  public static JoystickButton getClawCloseButton() {
    return clawCloseButton;
  }

  public static JoystickButton getCorrectChassisOrientationButton() {
    return correctChassisOrientationButton;
  }

  public static JoystickButton getCorrectElevatorOrientationButton() {
    return correctElevatorOrientationButton;
  }

 
}
