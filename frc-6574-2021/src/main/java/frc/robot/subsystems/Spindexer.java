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

public class Spindexer extends SubsystemBase {
  /**
   * Creates a new Spindexer.
   */
  public Spindexer() {
    final CANSparkMax Spindexer = new CANSparkMax(RobotCANMap.SPINDEXER_CANID, MotorType.kBrushless);
    final CANSparkMax Feeder = new CANSparkMax(RobotCANMap.FEEDER_CANID, MotorType.kBrushless);
  }
public void turnOnForShooting(){

}
public void turnOnForIntake(){

}
public void turnOff(){

}
public void reverseForIntake(){

}
public void stopFeeder(){

}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
