// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

  private static Spark motor1;
  private static Spark motor2;
  
  /** Creates a new ExampleSubsystem. */
  public ElevatorSubsystem() {
    motor1 = new Spark(Constants.MOTOR1_ID);
    motor2 = new Spark(Constants.MOTOR2_ID);
   
  }

  @Override
  public void periodic() 
  {
  
    motor1.set(ControllerSubsystem.getController1().getRawAxis(Constants.RIGHT_JOYSTICK_Y_AXIS * Constants.MOTOR_SPEED_MULTIPLIER));
    // This method will be called once per scheduler run
    motor2.set( ControllerSubsystem.getController1().getRawAxis(Constants.RIGHT_JOYSTICK_Y_AXIS) * Constants.MOTOR_SPEED_MULTIPLIER * Constants.OPPOSITE_DIRECTION);
    
    // motor1.set(ControllerSubsystem.getController1().getRawAxis(5) * 0.25);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}