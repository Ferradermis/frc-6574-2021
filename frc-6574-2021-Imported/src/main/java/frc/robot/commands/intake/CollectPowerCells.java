/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class CollectPowerCells extends CommandBase {
  /**
   * Creates a new Collect.
   */
  /*public CollectPowerCells() {
     addRequirements(RobotContainer.intake);
     addRequirements(RobotContainer.spindexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.intake.deploy();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.intake.collect();
    RobotContainer.spindexer.spinCounterClockwise(false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.intake.retract();
    RobotContainer.intake.stop();
    RobotContainer.spindexer.stopSpinning();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }*/
}
