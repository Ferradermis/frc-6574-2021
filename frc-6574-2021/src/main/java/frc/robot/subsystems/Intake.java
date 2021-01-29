/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotCANMap;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  public Intake() {
    final CANSparkMax Intake = new CANSparkMax(RobotCANMap.INTAKE_MOTOR_CANID, MotorType.kBrushless);

  }
public void turnOn(){

}
public void turnOff(){

}
public void reverseOn(){

}
public void deployOrRetract(){

}
public void deploy(){

}
public void retract(){

}
public void configureMotors(){

}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
