/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotCANMap;
import frc.robot.commands.drivetrain.ArcadeDrive;

public class DriveTrain extends SubsystemBase {

  public WPI_TalonFX frontLeft = new WPI_TalonFX(RobotCANMap.FRONT_LEFT_CANID);
  public WPI_TalonFX backLeft = new WPI_TalonFX(RobotCANMap.BACK_LEFT_CANID);
  public WPI_TalonFX frontRight = new WPI_TalonFX(RobotCANMap.FRONT_RIGHT_CANID);
  public WPI_TalonFX backRight = new WPI_TalonFX(RobotCANMap.BACK_RIGHT_CANID);
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    frontLeft.configFactoryDefault();
    backLeft.configFactoryDefault();
    frontRight.configFactoryDefault();
    backRight.configFactoryDefault();

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
    setDefaultCommand(new ArcadeDrive());
  }

  public void stop(){
    frontLeft.stopMotor();
    frontRight.stopMotor();
  }

  public void arcadeDrive(double drive, double steer){
    if ((Math.abs(drive) <= 0.00) && (Math.abs(steer) <= 0.00)) {
      stop();
      return;
    }

    double leftSpeed = drive + steer;
    double rightSpeed = drive - steer;

    if (leftSpeed > 1) { leftSpeed = 1; }
      else if (leftSpeed < -1) {leftSpeed = -1;}

    if (rightSpeed  > 1) {rightSpeed = 1;}
     else if (rightSpeed < -1) {rightSpeed = -1;}
   
     frontLeft.set(ControlMode.PercentOutput,-leftSpeed);
     frontRight.set(ControlMode.PercentOutput,-rightSpeed);
  }

  public void turnToHeading(){

  }
  
  public void resetgyro(){

  }

}
