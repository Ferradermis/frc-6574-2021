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

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    final WPI_TalonFX shooterRedTube = new WPI_TalonFX(RobotCANMap.SHOOTERREDTUBE_CANID);
    final WPI_TalonFX shooterBlackTube = new WPI_TalonFX(RobotCANMap.SHOOTERBLACKTUBE_CANID);
  }
public void spin(){

}
public void feedAndFire(){

}
public void setVelocity(){

}
public void stopFiring(){

}
public void stopShooting(){

}
public void raiseHoodForShooting(){

}
public void lowerHoodForTrench(){

}
public void extendHoodForLongDistance(){

}
public void retractHoodForShortDistance(){

}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
