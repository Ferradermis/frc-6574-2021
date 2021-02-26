/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotCANMap;
import frc.robot.commands.drivetrain.ArcadeDrive;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonFX frontLeft = new WPI_TalonFX(RobotCANMap.FRONT_LEFT_CANID);
  private WPI_TalonFX backLeft = new WPI_TalonFX(RobotCANMap.BACK_LEFT_CANID);
  private WPI_TalonFX frontRight = new WPI_TalonFX(RobotCANMap.FRONT_RIGHT_CANID);
  private WPI_TalonFX backRight = new WPI_TalonFX(RobotCANMap.BACK_RIGHT_CANID);
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
    //setDefaultCommand(new ArcadeDrive());
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
  private void configureMotors() {

    double rampRate = 0.35; //time in seconds to go from 0 to full throttle

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
    //thirdRight.follow(frontRight);
    //thirdLeft.follow(frontRight);

    frontLeft.configFactoryDefault();
    frontRight.configFactoryDefault();
    backLeft.configFactoryDefault();
    backRight.configFactoryDefault();
    //thirdRight.configFactoryDefault();
    //thirdLeft.configFactoryDefault();

    frontLeft.configOpenloopRamp(rampRate);
    backLeft.configOpenloopRamp(rampRate);
    frontRight.configOpenloopRamp(rampRate);
    backRight.configOpenloopRamp(rampRate);
    //thirdLeft.configOpenloopRamp(rampRate);
    //thirdRight.configOpenloopRamp(rampRate);

    frontRight.setInverted(true);
    backRight.setInverted(true);
    //thirdRight.setInverted(true);


    frontLeft.setNeutralMode(NeutralMode.Brake);
    backLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
    backRight.setNeutralMode(NeutralMode.Brake);
  }
}
