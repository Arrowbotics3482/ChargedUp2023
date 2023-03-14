// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.Rev2mDistanceSensor;
import com.revrobotics.Rev2mDistanceSensor.Port;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {

  private static Spark elevatorMotor1;
  private static Spark elevatorMotor2;
  //private static Rev2mDistanceSensor distSens;

  
  /** Creates a new ExampleSubsystem. */
  public ElevatorSubsystem() {
    elevatorMotor1 = new Spark(Constants.ELEVATORMOTOR1_ID);
    elevatorMotor2 = new Spark(Constants.ELEVATORMOTOR2_ID);
    //distSens = new Rev2mDistanceSensor(Port.kOnboard);
  }

  @Override
  public void periodic() 
  {
    elevatorMotor1.set(ControllerSubsystem.getController1().getRawAxis(Constants.ELEVATOR_AXIS_ID) * Constants.ELEVATOR_SPEED_MULTIPLIER);
    elevatorMotor2.set(ControllerSubsystem.getController1().getRawAxis(Constants.ELEVATOR_AXIS_ID) * Constants.ELEVATOR_SPEED_MULTIPLIER);
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static Spark getMotor1() {
    return motor1;
  }

  public static Spark getMotor2() {
    return motor2;
  }
/* 
  public static Rev2mDistanceSensor getDistSens() {
    return distSens;
  }
  */
}