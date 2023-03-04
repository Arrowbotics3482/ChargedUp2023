// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PivotArmSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private static Spark pivotNEO;
  private static Encoder encoder;
  private static boolean direction;
  private static double distance;

  public PivotArmSubsystem() {
    pivotNEO = new Spark(Constants.pivotArmMotorID);
    encoder = new Encoder(0, 1);
    encoder.reset();
    encoder.setDistancePerPulse(Constants.ENCODER_DISTANCE_PER_PULSE);
    distance = encoder.getDistance();
    //change channel later
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
    direction = encoder.getDirection();
    double temp = encoder.getDistance();
    if(!direction && distance > 0){
      distance = temp - encoder.getDistance();
    }

    if(direction && distance < 0){
      distance = temp - encoder.getDistance();
    }

    if(encoder.getDistance() == distance){
      encoder.reset();
    }

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static Spark getNEO(){
    return pivotNEO;
  }

  public static Encoder getEncoder(){
    return encoder;
  }
  
  public static boolean getConstantDirection(){
    return direction;
  }

  public static double getConstantDistance(){
    return distance;
  }
}
