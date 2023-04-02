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
  private static Joystick controllerMaster;
  private static JoystickButton clawIntakeButton;
  private static JoystickButton clawEjectButton;
  private static JoystickButton correctRobotXButton;
  private static JoystickButton correctRobotYButton;
  private static JoystickButton driveFBFineTuneButton;
  private static JoystickButton driveTurnFineTuneButton;
  private static JoystickButton elevatorFineTuneButton;
  private static POVButton macroElevatorDeployButton;

  public ControllerSubsystem() {
    controller1 = new Joystick(Constants.CONTROLLER1_ID); 
    controller2 = new Joystick(Constants.CONTROLLER2_ID);
    controllerMaster = new Joystick(Constants.CONTROLLERMASTER_ID);

    clawIntakeButton = new JoystickButton(controller1, Constants.CLAW_INTAKE_BUTTON_ID);
    clawEjectButton = new JoystickButton(controller1, Constants.CLAW_EJECT_BUTTON_ID);

    correctRobotXButton = new JoystickButton(controller2, Constants.CORRECT_ROBOT_X_BUTTON_ID);
    correctRobotYButton = new JoystickButton(controller2, Constants.CORRECT_ROBOT_Y_BUTTON_ID);

    driveFBFineTuneButton = new JoystickButton(controller1, Constants.DRIVE_FB_FINE_TUNE_BUTTON_ID);
    driveTurnFineTuneButton = new JoystickButton(controller1, Constants.DRIVE_TURN_FINE_TUNE_BUTTON_ID);

    elevatorFineTuneButton = new JoystickButton(controller2, Constants.ELEVATOR_FINE_TUNE_BUTTON);

    macroElevatorDeployButton = new POVButton(controller2, 0);
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

  public static Joystick getControllerMaster() {
    return controllerMaster;
  }

  public static JoystickButton getClawIntakeButton() {
    return clawIntakeButton;
  }

  public static JoystickButton getClawEjectButton() {
    return clawEjectButton;
  }

  public static JoystickButton getCorrectRobotXButton() {
    return correctRobotXButton;
  }

  public static JoystickButton getCorrectRobotYButton() {
    return correctRobotYButton;
  }

  public static JoystickButton getDriveFBFineTuneButton()
  {
    return driveFBFineTuneButton;
  }

  public static JoystickButton getDriveTurnFineTuneButton()
  {
    return driveTurnFineTuneButton;
  }

  public static JoystickButton getElevatorFineTuneButton()
  {
    return elevatorFineTuneButton;
  }

  public static POVButton getMacroElevatorDeployButton()
  {
    return macroElevatorDeployButton;
  }
}
