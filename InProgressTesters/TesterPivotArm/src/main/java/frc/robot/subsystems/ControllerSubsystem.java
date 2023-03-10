// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.ModuleLayer.Controller;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class ControllerSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private static POVButton topPOV;
  private static POVButton bottomPOV;
  private static Joystick controller2;
  private static JoystickButton zeroPivotArmButton;


  public ControllerSubsystem() {
    controller2 = new Joystick(1);
    topPOV = new POVButton(controller2, 0);
    bottomPOV = new POVButton(controller2, 180);
    levelPivotArmButton = new JoystickButton(controller2, 1);
  }

  public static Joystick getController2(){
    return controller2;
  }

  public static POVButton getTopPOV(){
    return topPOV;
  }

  public static POVButton getBottomPOV(){
    return bottomPOV;
  }

  public static JoystickButton getZeroPivotArmButton(){
    return zeroPivotArmButton;
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
}
