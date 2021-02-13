/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotCANMap;

public class Shooter extends SubsystemBase {

  public WPI_TalonFX shooterRed = new WPI_TalonFX(RobotCANMap.SHOOTER_RED_CANID);
  public WPI_TalonFX shooterBlackMain = new WPI_TalonFX(RobotCANMap.SHOOTER_BLACK_CANID);

  public DoubleSolenoid hoodTrench = new DoubleSolenoid(RobotCANMap.HOOD_TRENCH_ID1, RobotCANMap.HOOD_TRENCH_ID2);
  public DoubleSolenoid hoodAngle = new DoubleSolenoid(RobotCANMap.HOOD_ANGLE_ID2, RobotCANMap.HOOD_ANGLE_ID1);

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
    hoodTrench.set(DoubleSolenoid.Value.kForward);
  }


  public void lowerHoodForTrench(){
    hoodAngle.set(DoubleSolenoid.Value.kReverse);
    Timer.delay(1);
    hoodTrench.set(DoubleSolenoid.Value.kReverse);
  }


  public void extendHoodForLongDistance(){
    // only extend distance hood if trenchHood raised and hoodAngle is down
    if (hoodTrench.get() == DoubleSolenoid.Value.kForward){
      hoodAngle.set(DoubleSolenoid.Value.kForward);
              }
  }


  public void retractHoodForShortDistance(){
      hoodAngle.set(DoubleSolenoid.Value.kReverse);
  }
}
