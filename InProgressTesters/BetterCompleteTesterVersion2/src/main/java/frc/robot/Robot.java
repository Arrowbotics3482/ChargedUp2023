// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants.ClawAdjust;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items
   * like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
    ElevatorSubsystem.getDistSens().setAutomaticMode(false);
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    ElevatorSubsystem.getDistSens().setAutomaticMode(true);
    ElevatorSubsystem.getDistSens().setEnabled(true);
    if (ClawSubsystem.getClawAdjustState() == ClawAdjust.OFF) {
      ClawSubsystem.getClawMotor().set(0.2);
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    DriveSubsystem.drive();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {
  }
  /*
   * private void createCamera() {
   * m_visionThread = new Thread(
   * () -> {
   * // Get the UsbCamera from CameraServer
   * UsbCamera camera = CameraServer.startAutomaticCapture();
   * // Set the resolution
   * camera.setResolution(240, 180);
   * 
   * // Get a CvSink. This will capture Mats from the camera
   * CvSink cvSink = CameraServer.getVideo();
   * 
   * // Mats are very memory expensive. Lets reuse this Mat.
   * Mat mat = new Mat();
   * 
   * // Put a rectangle on the image
   * Imgproc.rectangle(mat, new Point(20, 20), new Point(50, 50), new Scalar(255,
   * 0, 0), 20);
   * 
   * // Setup a CvSource. This will send images back to the Dashboard
   * CvSource outputStream = CameraServer.putVideo("Rectangle", 240, 180);
   * 
   * // This cannot be 'true'. The program will never exit if it is. This lets the
   * // robot stop this thread when restarting robot code or deploying.
   * while (!Thread.interrupted()) {
   * // Tell the CvSink to grab a frame from the camera and put it in the source
   * mat.
   * // If there is an error notify the output.
   * if (cvSink.grabFrame(mat) == 0) {
   * // Send the output the error.
   * outputStream.notifyError(cvSink.getError());
   * // Skip the rest of the current iteration
   * continue;
   * }
   * 
   * // Put a rectangle on the image
   * Imgproc.line(mat, new Point(20, 20), new Point(50, 50), new Scalar(255, 0,
   * 0), 20);
   * 
   * outputStream.putFrame(mat);
   * HighGui.imshow("lmao", mat);
   * HighGui.waitKey();
   * }
   * });
   * m_visionThread.setDaemon(true);
   * m_visionThread.start();
   * }
   */
}
