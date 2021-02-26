/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotCANMap;

public class Intake extends SubsystemBase {

  public CANSparkMax intake = new CANSparkMax(RobotCANMap.INTAKE_MOTOR_CANID, MotorType.kBrushless);
  public DoubleSolenoid deployer = new DoubleSolenoid(RobotCANMap.INTAKE_EXTENDER_ID1, RobotCANMap.INTAKE_EXTENDER_ID2);

  private double collectingSpeed = .75;
  private double repellingSpeed = -1;

  /**
   * Creates a new Intake.
   */
  public Intake() {
    intake.restoreFactoryDefaults();
    retract();
  }

  //Spins rollers inward.
  public void collect(){
    intake.set(collectingSpeed);
  }

  //Stops spinning rollers.
  public void stop(){
    intake.stopMotor();
  }

  //Spins rollers outward.
  public void repel(){
    intake.set(repellingSpeed);
  }

  //Deploy intake.
  public void deploy(){
    deployer.set(DoubleSolenoid.Value.kReverse);
  }

  //Retract intake.
  public void retract(){
    deployer.set(DoubleSolenoid.Value.kForward);
  }

}
