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

  private static Spark motor1;
  private static Spark motor2;

  // Distance Sensor stuff:
  private static Rev2mDistanceSensor distSens;

  private static final String profileDefault;
  private static final String highSpeed;
  private static final String highAccuracy;
  private static final String longRange;
  private String m_profileSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  
  /** Creates a new ExampleSubsystem. */
  public ElevatorSubsystem() {
    motor1 = new Spark(Constants.MOTOR1_ID);
    motor2 = new Spark(Constants.MOTOR2_ID);

    // Distance Sensor:

    profileDefault = "Default";
    highSpeed = "High Speed";
    highAccuracy = "High Accuracy";
    longRange = "Long Range";

    m_chooser.setDefaultOption("Default", profileDefault);
    m_chooser.addOption("High Speed", highSpeed);
    m_chooser.addOption("High Accuracy", highAccuracy);
    m_chooser.addOption("Long Range", longRange);
    
    distSens = new Rev2mDistanceSensor(Port.kOnboard);

  }

  @Override
  public void periodic() 
  {
    
    motor1.set(ControllerSubsystem.getController1().getRawAxis(Constants.RIGHT_JOYSTICK_Y_AXIS) * Constants.MOTOR_SPEED_MULTIPLIER);
    // This method will be called once per scheduler run
    motor2.set(ControllerSubsystem.getController1().getRawAxis(Constants.RIGHT_JOYSTICK_Y_AXIS) * Constants.MOTOR_SPEED_MULTIPLIER * Constants.OPPOSITE_DIRECTION);
    
    // DISTANCE SENSOR STUFF!
    
    distSens.setAutomatic(true);
    distSens.setEnabled(true);
    // you may need to actually put all of this code in Robot.java because you need to disable the distSens in disabledInit


    m_profileSelected = m_chooser.getSelected();

    switch (m_profileSelected)
    {
      case highSpeed:
        distSens.setRangeProfile(RangeProfile.kHighSpeed);
        break;
      case highAccuracy:
        distSens.setRangeProfile(RangeProfile.kHighAccuracy);
        break;
      case longRange:
        distSens.setRangeProfile(RangeProfile.kLongRange);
        break;
      default:
        distSens.setRangeProfile(RangeProfile.kDefault);
        break;
      
        boolean isValid = distSense.isRangeValid();
        SmartDashboard.putBoolean("Valid", isValid);
        if (isValid)
        {
          SmartDashboard.putNumber("Range", distSens.getRange());
          SmartDashboard.putNumber("Timestamp", distSens.getTimestamp());
        }
      
      
    }

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