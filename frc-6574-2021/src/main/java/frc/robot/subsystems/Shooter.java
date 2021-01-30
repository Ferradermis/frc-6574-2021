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

public class Shooter extends SubsystemBase {

  public WPI_TalonFX shooterRed = new WPI_TalonFX(RobotCANMap.SHOOTER_RED_CANID);
  public WPI_TalonFX shooterBlackMain = new WPI_TalonFX(RobotCANMap.SHOOTER_BLACK_CANID);

  private int shootVelocity = 1;

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    shooterRed.configFactoryDefault();
    shooterBlackMain.configFactoryDefault();
    shooterRed.setInverted(true);
    shooterRed.follow(shooterBlackMain);

    lowerHoodForTrench();
    retractHoodForShortDistance();
  }
  public void spin(){
    shooterBlackMain.set(ControlMode.Velocity,shootVelocity);
  }

  public void stopShooting(){
    shooterBlackMain.stopMotor();

  }
  public void raiseHoodForShooting(){

  }
  public void lowerHoodForTrench(){

  }
  public void extendHoodForLongDistance(){

  }
  public void retractHoodForShortDistance(){

  }
}
