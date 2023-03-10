// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Twist2d;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class PivotArmSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private static Spark pivotMotor;
  private static Encoder encoder;
  
  private static boolean direction;

  private static double currentMotorRate;
  private static double previousMotorRate;

  private static double displacement;

  // private static int count;
  // private static Twist2d twist2D = new Twist2d(0, 0, 0);
  

  public PivotArmSubsystem() {
    pivotMotor = new Spark(Constants.pivotArmMotorID);
    encoder = new Encoder(0, 1);
    currentMotorRate = 0;
    previousMotorRate = 0;
    displacement = 0;
    encoder.reset();
    // count = 0;
    // encoder.setDistancePerPulse(Constants.ENCODER_DISTANCE_PER_PULSE);
    // displacement = encoder.getDistance();
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
    // displacement = (.02)

    // count++;

    currentMotorRate = encoder.getRate(); 
    displacement = displacement + ( (currentMotorRate - previousMotorRate) / 0.02 ); // idk if 0.02 would be right because idk what measurements the rate is taken in. rpm prob but i was too lazy to convert it
    previousMotorRate = currentMotorRate;

    // do we need to use getDistancePerPulse or getDistance

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static Spark getPivotMotor(){
    return pivotMotor;
  }

  public static Encoder getEncoder(){
    return encoder;
  }

  /*
  public static double getConstantDisplacement(){
    return displacement;
  }
  */

  public static void resetDisplacement()
  {
    displacement = 0;
  }

  public static double getDisplacement()
  {
    return displacement;
  }
}
