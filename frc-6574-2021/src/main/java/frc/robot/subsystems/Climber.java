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

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  public Climber() {
    final CANSparkMax Elevator = new CANSparkMax(RobotCANMap.ELEVATOR_CANID, MotorType.kBrushless);
    final CANSparkMax Wench = new CANSparkMax(RobotCANMap.WENCH_CANID, MotorType.kBrushless);
  }
public void deploy(){

}
public void retract(){

}
public void move(){

}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
