// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.ClawDirection;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoDockCommand;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.Autos;
import frc.robot.commands.ClawCommand;
import frc.robot.commands.CorrectRobotX;
import frc.robot.commands.CorrectRobotY;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MacroElevatorDeployCommand;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

import java.lang.ModuleLayer.Controller;
import java.util.ResourceBundle.Control;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ControllerSubsystem controllerSubsystem = new ControllerSubsystem();
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private ClawSubsystem clawSubsystem = new ClawSubsystem();
  // where you should change the start position for auton!
   private final AutoDriveCommand autoDrive = new AutoDriveCommand(driveSubsystem, elevatorSubsystem, clawSubsystem, Constants.AutonStartPosition.BLUE_SHORT);
  // // private final AutoDockCommand autoDrive = new AutoDockCommand(driveSubsystem, elevatorSubsystem, pneumaticClawSubsystem);
  private final AutoDockCommand autoDock = new AutoDockCommand(driveSubsystem, elevatorSubsystem, clawSubsystem);


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    
    ControllerSubsystem.getCorrectRobotXButton().whileTrue(new CorrectRobotX(limelightSubsystem));
    ControllerSubsystem.getCorrectRobotYButton().whileTrue(new CorrectRobotY(limelightSubsystem));
    ControllerSubsystem.getClawEjectButton().whileTrue(new ClawCommand(clawSubsystem, ClawDirection.OUT));
    ControllerSubsystem.getClawIntakeButton().whileTrue(new ClawCommand(clawSubsystem, ClawDirection.IN));
    ControllerSubsystem.getMacroElevatorDeployButton().whileTrue(new MacroElevatorDeployCommand(elevatorSubsystem));
  }

  /*
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return autoDock;
  }
}
