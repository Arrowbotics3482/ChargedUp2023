// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class ControllerSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private static Joystick controller1;
  private static Joystick controller2;
  private static POVButton pivotArmForwardButton;
  private static POVButton pivotArmBackwardButton;

  public ControllerSubsystem() {
    controller1 = new Joystick(0); // may need to change
    controller2 = new Joystick(1);
    pivotArmForwardButton = new POVButton(controller2, 0);
    pivotArmBackwardButton = new POVButton(controller2, 180);
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

  public static Joystick getController1()
  {
    return controller1;
  }

  public static Joystick getController2()
  {
    return controller2;
  }

  public static POVButton getPivotArmForwardButton()
  {
    return pivotArmForwardButton;
  }

  public static POVButton getPivotArmBackwardButton()
  {
    return pivotArmBackwardButton;
  }

}
