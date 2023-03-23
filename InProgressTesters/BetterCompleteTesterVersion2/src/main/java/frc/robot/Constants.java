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
  public static final int CONTROLLER1_ID = 0;
  public static final int CONTROLLER2_ID = 1;
  public static final int CLAW_OPEN_BUTTON_ID = 1;
  public static final int CLAW_CLOSE_BUTTON_ID = 2;
  public static final int CORRECT_ROBOT_Y_BUTTON_ID = 4;
  public static final int CORRECT_ROBOT_X_BUTTON_ID = 3;
  public static final int DRIVE_FB_FINE_TUNE_BUTTON_ID = 5;
  public static final int DRIVE_TURN_FINE_TUNE_BUTTON_ID = 6;

  public static final int DRIVE_FB_AXIS_ID = 1;
  public static final int DRIVE_TURN_AXIS_ID = 4;
  public static final double DRIVE_LIMIT_COEFFICIENT = 0.7;
  public static final double DRIVE_FINE_TUNE_PROPORTION = 0.7;

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
  public static final double ELEVATOR_SPEED_MULTIPLIER = 0.5;
  public static final int ELEVATOR_AXIS_ID = 1;
  public static final double ELEVATOR_MIN_LIMIT = 0.5;
  public static final double ELEVATOR_MAX_LIMIT = 18;

  public static final int PIVOT_ARM_MOTOR_CHANNEL = 6;
  public static final double PIVOT_MOTOR_SPEED = 0.6;

  public enum PivotDirection
  {
    UP, DOWN
  }

  public enum ClawPosition
  {
    OPEN, CLOSE
  }

  public static final double LIMELIGHT_Y_THRESHOLD = 20;
  public static final double LIMELIGHT_X_THRESHOLD = 2;

  public enum AutonStartPosition
  {
    RED_SHORT_OR_BLUE_LONG, RED_LONG_OR_BLUE_SHORT;
  }
}
