// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.Rev2mDistanceSensor;
import com.revrobotics.Rev2mDistanceSensor.Port;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ElevatorAdjust;

public class ElevatorSubsystem extends SubsystemBase {

  private static Spark elevatorMotor1;
  private static Spark elevatorMotor2;
  private static ElevatorAdjust elevatorAdjust;
  private static Rev2mDistanceSensor distSens;

  
  /** Creates a new ExampleSubsystem. */
  public ElevatorSubsystem() {
    elevatorMotor1 = new Spark(Constants.ELEVATOR_MOTOR1_CHANNEL);
    elevatorMotor2 = new Spark(Constants.ELEVATOR_MOTOR2_CHANNEL);
    elevatorAdjust = ElevatorAdjust.OFF;
    distSens = new Rev2mDistanceSensor(Port.kOnboard);
  }

  @Override
  public void periodic() 
  {
    if(distSens.isRangeValid()) {
      SmartDashboard.putNumber("Range Onboard", distSens.getRange());
    } 
    
    if(elevatorAdjust == ElevatorAdjust.OFF)
    {
      if(distSens.getRange() <= Constants.ELEVATOR_MIN_LIMIT)
      {
        if(ControllerSubsystem.getController2().getRawAxis(Constants.ELEVATOR_AXIS_ID) < 0)
        {
          if(ControllerSubsystem.getElevatorFineTuneButton().getAsBoolean())
          {
            runElevator(ControllerSubsystem.getController2().getRawAxis(Constants.ELEVATOR_AXIS_ID) * Constants.ELEVATOR_SPEED_FINE_TUNE_MULTIPLIER);
          }
          else
          {
            runElevator(ControllerSubsystem.getController2().getRawAxis(Constants.ELEVATOR_AXIS_ID) * Constants.ELEVATOR_SPEED_MULTIPLIER);
          }
        }
        else
        {
          runElevator(0);
        }
      }
      else if(distSens.getRange() >= Constants.ELEVATOR_MAX_LIMIT)
      {
        if(ControllerSubsystem.getController2().getRawAxis(Constants.ELEVATOR_AXIS_ID) > 0)
        {
          if(ControllerSubsystem.getElevatorFineTuneButton().getAsBoolean())
          {
            runElevator(ControllerSubsystem.getController2().getRawAxis(Constants.ELEVATOR_AXIS_ID) * Constants.ELEVATOR_SPEED_FINE_TUNE_MULTIPLIER);
          }
          else
          {
            runElevator(ControllerSubsystem.getController2().getRawAxis(Constants.ELEVATOR_AXIS_ID) * Constants.ELEVATOR_SPEED_MULTIPLIER);
          }
        }
        else
        {
          runElevator(0);
        }
      }
      else
      {
        if(ControllerSubsystem.getElevatorFineTuneButton().getAsBoolean())
        {
          runElevator(ControllerSubsystem.getController2().getRawAxis(Constants.ELEVATOR_AXIS_ID) * Constants.ELEVATOR_SPEED_FINE_TUNE_MULTIPLIER);
        }
        else
        {
          runElevator(ControllerSubsystem.getController2().getRawAxis(Constants.ELEVATOR_AXIS_ID) * Constants.ELEVATOR_SPEED_MULTIPLIER);
        }
      }
    }
    // ONE OF THESE MOTORS NEEDS TO GO IN THE OPPOSITE WAY
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static void runElevator(double speed)
  {
    elevatorMotor1.set(speed);
    elevatorMotor2.set(-1* speed);
  }
  public static Spark getMotor1() {
    return elevatorMotor1;
  }

  public static Spark getMotor2() {
    return elevatorMotor2;
  }

  public static Rev2mDistanceSensor getDistSens() {
    return distSens;
  }
  
  public static ElevatorAdjust getElevatorAdjustState()
  {
    return elevatorAdjust;
  }

  public static void switchElevatorAdjust()
  {
    if(elevatorAdjust == ElevatorAdjust.ON)
    {
      elevatorAdjust = ElevatorAdjust.OFF;
    }
    else if(elevatorAdjust == ElevatorAdjust.OFF)
    {
      elevatorAdjust = ElevatorAdjust.ON;
    }
  }
}