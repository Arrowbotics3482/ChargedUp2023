// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ControllerSubsystem extends SubsystemBase
{
 
  private static Joystick controller1;

  // private static JoystickButton button1; THIS ISNT NEEDED FOR ELEVATOR!

  public ControllerSubsystem()
  {
  controller1 = new Joystick(Constants.CONTROLLER_ID); 
  }
  // button1 = new JoystickButton(controller1, 1);


  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic()
  {
    // This method will be called once per scheduler run during simulation
  }


  public static Joystick getController1()
  {
    return controller1;
  }


}
