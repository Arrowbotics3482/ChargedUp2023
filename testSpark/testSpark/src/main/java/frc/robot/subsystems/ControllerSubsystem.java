// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class ControllerSubsystem extends SubsystemBase {

  //private static Joystick controller;
  private static POVButton button;
  //private static JoystickButton buton;
  private static GenericHID controller;

  /** Creates a new ExampleSubsystem. */
  
  public ControllerSubsystem() {
    //controller = new Joystick(0);
    controller = new GenericHID(0);
    button = new POVButton(controller, 0);
    // buton = new JoystickButton(controller, 1);

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

  public static GenericHID getController()
  {
    return controller;
  }
  public static POVButton getButton()
  {
    return button;
  }
  
  /*
   * public static JoystickButton getButon(){
    return buton;
  }
   */
  
}
