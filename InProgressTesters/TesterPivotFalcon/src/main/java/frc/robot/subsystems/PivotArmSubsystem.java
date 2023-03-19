// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.geometry.Twist2d;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class PivotArmSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private static TalonFX pivotMotor;
  // private static Encoder encoder;
  
  private static boolean direction;

  private static double currentMotorRate;
  private static double previousMotorRate;

  private static double displacement;
  

  public PivotArmSubsystem() {
    pivotMotor = new TalonFX(Constants.PIVOT_ARM_MOTOR_ID);
    pivotMotor.setNeutralMode(NeutralMode.Brake);
    //encoder = new Encoder(0, 1);
    currentMotorRate = 0;
    previousMotorRate = 0;
    displacement = 0;
    //encoder.reset();
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
    /* 
    currentMotorRate = encoder.getRate(); 
    displacement = displacement + ( (currentMotorRate - previousMotorRate) / 0.02 ); // idk if 0.02 would be right because idk what measurements the rate is taken in. rpm prob but i was too lazy to convert it
    previousMotorRate = currentMotorRate;

    SmartDashboard.putNumber("Current Motor Speed", currentMotorRate);
    SmartDashboard.putNumber("Displacement", displacement);
    */
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static TalonFX getPivotMotor(){
    return pivotMotor;
  }

  /*
  public static Encoder getEncoder(){
    return encoder;
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
