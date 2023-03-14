// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.nio.channels.Channel;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  
  //private static Spark motor; // the CANSparkMax doesn't exist
  //private static Encoder encoder;
  //private static DutyCycleEncoder dualEncoder;
  private static CANSparkMax motor;
  // private static Encoder encoder;
  //private static PWMSparkMax motor1;
  private static RelativeEncoder encoder;
  
  // private Talon motor2;

  public MotorSubsystem() {
    //motor = new Spark(4);
   
    //motor1 = new PWMSparkMax(0);
    // encoder1 = new RelativeEncoder(0, 1, 0);
     //encoder = new Encoder(0, 1); // may need to change the DIO ports

     
     
     
     
     motor = new CANSparkMax(10, MotorType.kBrushed);
     
     // BRUSHED MODE GIVES US AN ERROR --> [CAN SPARK MAX] IDs: 10, timed out while waiting for Periodic Status 4 ﻿﻿  ﻿﻿﻿

     
     
     //encoder = motor.getAlternateEncoder();

    encoder = motor.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 4096);

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
    //SmartDashboard.putNumber("axis value: ", ControllerSubsystem.getController().getRawAxis(1));
    //SmartDashboard.putNumber("Motor Speed: ", encoder.getRate());
    //SmartDashboard.putNumber("distance?? ", dualEncoder.getDistance());
    SmartDashboard.putNumber("motor speed: ", encoder.getVelocity());
    SmartDashboard.putNumber("motor position: ", encoder.getPosition()); // returns the rotations                                                                                 

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static CANSparkMax getMotor()
  {
    return motor;
  }

}
