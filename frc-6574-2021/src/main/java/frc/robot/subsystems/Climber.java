/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotCANMap;

public class Climber extends SubsystemBase {

  public CANSparkMax elevator = new CANSparkMax(RobotCANMap.ELEVATOR_CANID, MotorType.kBrushless);
  public CANSparkMax winch = new CANSparkMax(RobotCANMap.WINCH_CANID, MotorType.kBrushless);

  final DoubleSolenoid.Value DEPLOYED = DoubleSolenoid.Value.kForward;
  final DoubleSolenoid.Value RETRACTED = DoubleSolenoid.Value.kReverse;
 


  final double elevatorSpeed = .15;
  /**
   * Creates a new Climber.
   */
  public Climber() {
    double rampRate = 0.2;
    int currentLimit = 40;
    elevator.setOpenLoopRampRate(rampRate); //makes sure it doesn't go too fast when it is about to end?
    winch.setOpenLoopRampRate(rampRate);

    elevator.setSmartCurrentLimit(currentLimit); //will stop power if stuck
    winch.setSmartCurrentLimit(currentLimit);

    elevator.setInverted(true);
    elevator.setIdleMode(IdleMode.kBrake);
    winch.setIdleMode(IdleMode.kBrake);
  }



  public void moveElevatorStaticUp() {
    elevator.set(elevatorSpeed);
  }

  public void moveElevatorStaticDown() {
    elevator.set(-elevatorSpeed);
  }

  public void stopElevator() {
    elevator.set(0);
  }


  public void moveWinch(double yLeft) { 
    if ((Math.abs(yLeft) <= 0.1)) {
       //elevator.set(0);
       winch.set(0);
      return;
    }

  }
}
