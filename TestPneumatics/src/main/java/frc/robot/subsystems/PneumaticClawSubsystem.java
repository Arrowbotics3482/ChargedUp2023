// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticClawSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private static DoubleSolenoid piston;
  private static Compressor compressor;

 

  public PneumaticClawSubsystem() {
    piston = new DoubleSolenoid(PneumaticsModuleType.REVPH, 1, 0); // change this
    compressor = new Compressor(1, PneumaticsModuleType.REVPH); // the default module for PH is 1
    
    compressor.enableAnalog(1, 5); // check if the min pressure should be 30
    
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
    SmartDashboard.putNumber("Pressure value: ", (24.02 + compressor.getPressure())); // added 24.02 to zero it, but idk if it's even important to do so
  } 

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static Compressor getCompressor()
  {
    return compressor;
  }

  public static DoubleSolenoid getPiston()
  {
    return piston;
  }
}
