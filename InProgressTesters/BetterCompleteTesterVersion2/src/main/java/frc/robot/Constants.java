// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static final int CONTROLLER1_ID = 1;
  public static final int CONTROLLER2_ID = 0;
  public static final int CONTROLLERMASTER_ID = 2;
  public static final int CLAW_INTAKE_BUTTON_ID = 1;
  public static final int CLAW_EJECT_BUTTON_ID = 2;
  public static final int CORRECT_ROBOT_Y_BUTTON_ID = 4;
  public static final int CORRECT_ROBOT_X_BUTTON_ID = 3;
  public static final int DRIVE_FB_FINE_TUNE_BUTTON_ID = 5;
  public static final int DRIVE_TURN_FINE_TUNE_BUTTON_ID = 6;

  public static final int DRIVE_FB_AXIS_ID = 1;
  public static final int DRIVE_TURN_AXIS_ID = 4;
  public static final double DRIVE_LIMIT_COEFFICIENT = 0.88;
  public static final double DRIVE_FINE_TUNE_PROPORTION = 0.6;

  public enum DriveAdjust
  {
    ON, OFF
  }

  public enum ElevatorAdjust
  {
    ON, OFF
  }

  public static final int ELEVATOR_MOTOR1_CHANNEL = 4;
  public static final int ELEVATOR_MOTOR2_CHANNEL = 5;
  public static final double ELEVATOR_SPEED_MULTIPLIER = 0.5; // for DISTANCE SENSOR FINE TUNE
  
  public static final double ELEVATOR_SPEED_FINE_TUNE_MULTIPLIER = 0.3;

  public static final int ELEVATOR_AXIS_ID = 1;
  public static final int ELEVATOR_AXIS_FINE_TUNE_ID = 5;
  public static final double ELEVATOR_MIN_LIMIT = 0.5;
  public static final double ELEVATOR_MAX_LIMIT = 18;
  public static final int ELEVATOR_FINE_TUNE_BUTTON = 5;

  public static final double ELEVATOR_MACRO_DISTANCE = 17.15;
  public static final double ELEVATOR_MACRO_THRESHOLD = 0.25;

  public enum ClawDirection
  {
    IN, OUT
  }
  public enum ClawAdjust
  {
    ON, OFF
  }
  public static final int CLAW_MOTOR_CHANNEL = 6;
  public static final double CLAW_MOTOR_SPEED = 3.5;

  public static final double LIMELIGHT_Y_THRESHOLD = 20;
  public static final double LIMELIGHT_X_THRESHOLD = 2;

  public enum AutonStartPosition
  {
    // RED_SHORT_OR_BLUE_LONG, RED_LONG_OR_BLUE_SHORT
    // we need to define turning amount and direction through enum of auton start position
    RED_SHORT, RED_LONG, BLUE_SHORT, BLUE_LONG
  }
}
