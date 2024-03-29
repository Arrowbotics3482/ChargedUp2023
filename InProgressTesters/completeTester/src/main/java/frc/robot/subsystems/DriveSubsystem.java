
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

 
  private static Spark leftFrontMotor;
  private static Spark leftBackMotor;
  private static Spark rightFrontMotor;
  private static Spark rightBackMotor;

  private static MotorControllerGroup leftMotors;
  private static MotorControllerGroup rightMotors;

  private static DifferentialDrive drive;

  private static double fb;
  private static double turn;

  public DriveSubsystem() {
    leftFrontMotor = new Spark(3);
    leftBackMotor = new Spark(2);
    rightFrontMotor = new Spark(0);
    rightBackMotor = new Spark(1);


    leftMotors = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
    rightMotors = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
    
    leftMotors.setInverted(true);

    drive = new DifferentialDrive(leftMotors, rightMotors);
    
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
    SmartDashboard.putNumber("left joystick axis", ControllerSubsystem.getController1().getRawAxis(Constants.DRIVE_FB_AXIS_ID));
    SmartDashboard.putNumber("right joystick axis", ControllerSubsystem.getController1().getRawAxis(Constants.DRIVE_TURN_AXIS_ID));

    

    drive.setSafetyEnabled(true);

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static void drive()
  {
    fb = ControllerSubsystem.getController1().getRawAxis(Constants.DRIVE_FB_AXIS_ID) * Constants.DRIVE_LIMIT_COEFFICIENT;
    turn = ControllerSubsystem.getController1().getRawAxis(Constants.DRIVE_TURN_AXIS_ID) * Constants.DRIVE_LIMIT_COEFFICIENT;
    drive.arcadeDrive(fb, turn);
  }
}

