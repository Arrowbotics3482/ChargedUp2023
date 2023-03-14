// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PivotArmSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public static WPI_TalonSRX pivotArmMotor;
  public static Encoder pivotEncoder;

  public PivotArmSubsystem() {
    pivotArmMotor = new WPI_TalonSRX(Constants.PIVOT_ARM_MOTOR_ID);
    pivotEncoder = new Encoder(0, 1);
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
    SmartDashboard.putNumber("motor speed: ", pivotEncoder.getRate());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static WPI_TalonSRX getPivotArmMotor() {
    return pivotArmMotor;
  }

  public static Encoder getPivotEncoder() {
    return pivotEncoder;
  }
}
