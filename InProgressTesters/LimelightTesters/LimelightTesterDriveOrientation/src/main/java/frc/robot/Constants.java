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

  public static final int driveFBAxisID = 1;
  public static final int driveTurnAxisID = 4;
  public static final double driveLimitCoefficient = 0.4;

  public enum DriveAdjust
  {
    ON, OFF
  }

  public enum ElevatorAdjust
  {
    ON, OFF
  }

  public static final int ELEVATOR_MOTOR1_ID = 4;
  public static final int ELEVATOR_MOTOR2_ID = 5;

  public static final int CONTROLLER1_ID = 0;
  public static final int CONTROLLER2_ID = 1;

  public static final double ELEVATOR_SPEED_MULTIPLIER = 0.7;
  public static final int ELEVATOR_AXIS_ID = 1;
  public static final double LIMELIGHT_Y_THRESHOLD = 10;


}
