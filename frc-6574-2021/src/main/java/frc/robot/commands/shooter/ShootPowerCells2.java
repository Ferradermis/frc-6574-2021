/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.spindexer.SpindexForShooting;

public class ShootPowerCells2 extends SequentialCommandGroup {
  /**
   * Creates a new ShootPowerCells2.
   */
  public ShootPowerCells2() {
    // Use addRequirements() here to declare subsystem dependencies.
    super(
      new RaiseHood(), 
      new WaitCommand(2),
      new ParallelCommandGroup(
        new SpinShooter(),
        new SequentialCommandGroup(
          new WaitCommand(2),
          new ParallelCommandGroup(
            new SpinFeeder(),
            new SequentialCommandGroup(
              new WaitCommand(2),
              new SpindexForShooting()
            )
          )
        )
      )
      );
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
