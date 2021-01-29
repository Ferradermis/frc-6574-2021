/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotCANMap;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    final WPI_TalonFX FrontLeft = new WPI_TalonFX(RobotCANMap.FRONT_LEFT_CANID);
    final WPI_TalonFX BackLeft = new WPI_TalonFX(RobotCANMap.BACK_LEFT_CANID);
    final WPI_TalonFX FrontRight = new WPI_TalonFX(RobotCANMap.FRONT_RIGHT_CANID);
    final WPI_TalonFX BackRight = new WPI_TalonFX(RobotCANMap.BACK_RIGHT_CANID);
  }
public void stop(){

}
public void arcadeDrive(){

}
public void turnToHeading(){

}
public void resetgyro(){

}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
