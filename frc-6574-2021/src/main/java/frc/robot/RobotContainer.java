/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.CollectPowerCells;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Spindexer;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Climber climber = new Climber();
  public static DriveTrain driveTrain = new DriveTrain();
  public static Intake intake = new Intake();
  public static Shooter shooter = new Shooter();
  public static Spindexer spindexer = new Spindexer();

  public Joystick driver = new Joystick(0);
  public Joystick operator = new Joystick(1);

  //  STILL NEED TO FIGURE OUT TRIGGERS
  // xBox Variables
  public Button driver_aButton = new JoystickButton(driver, 1);
  public Button driver_bButton = new JoystickButton(driver, 2);
  public Button driver_xButton = new JoystickButton(driver, 3);
  public Button driver_yButton = new JoystickButton(driver, 4);
  public Button driver_leftBumper = new JoystickButton(driver, 5);
  public Button driver_rightBumper = new JoystickButton(driver, 6);
  public Button driver_leftTrigger = new XBoxLeftTrigger(driver);
  public Button driver_rightTrigger = new XBoxRightTrigger(driver);
  public Button driver_backButton = new JoystickButton(driver, 7);
  public Button driver_startButton = new JoystickButton(driver, 8);
  public POVButton driver_upDpad = new POVButton(driver, 0);
  public POVButton driver_rightDpad = new POVButton(driver, 90);
  public POVButton driver_downDpad = new POVButton(driver, 180);
  public POVButton driver_leftDpad = new POVButton(driver, 270);

  public double getDriverLeftX() {
    return driver.getRawAxis(0);
  }

  public double getDriverLeftY() {
    return driver.getRawAxis(1);
  }

  public double getDriverRightX() {
    return driver.getRawAxis(4);
  }

  public double getDriverRightY() {
    return driver.getRawAxis(5);
  }

  public double getDriverLeftTrigger() {
    return driver.getRawAxis(2);
  }

  public double getDriverRightTrigger() {
    return driver.getRawAxis(3);
  }

  public boolean getDriverLeftBumper() {
    return driver.getRawButton(5);
  }

  public boolean getDriverRightBumper() {
    return driver.getRawButton(6);
  }

  // operator Variables
  public Button operator_aButton = new JoystickButton(operator, 1);
  public Button operator_bButton = new JoystickButton(operator, 2);
  public Button operator_xButton = new JoystickButton(operator, 3);
  public Button operator_yButton = new JoystickButton(operator, 4);
  public Button operator_leftBumper = new JoystickButton(operator, 5);
  public Button operator_rightBumper = new JoystickButton(operator, 6);
  public Button operator_backButton = new JoystickButton(operator, 7);
  public Button operator_startButton = new JoystickButton(operator, 8);
  public Button operator_leftTrigger = new XBoxLeftTrigger(operator);
  public Button operator_rightTrigger = new XBoxRightTrigger(operator);
  public POVButton operator_upDpad = new POVButton(operator, 0);
  public POVButton operator_rightDpad = new POVButton(operator, 90);
  public POVButton operator_downDpad = new POVButton(operator, 180);
  public POVButton operator_leftDpad = new POVButton(operator, 270);

  public double getOperatorLeftX() {
    return operator.getRawAxis(0);
  }

  public double getOperatorLeftY() {
    return operator.getRawAxis(1);
  }

  public double getOperatorRightX() {
    return operator.getRawAxis(4);
  }

  public double getOperatorRightY() {
    return operator.getRawAxis(5);
  }

  public double getOperatorLeftTrigger() {
    return operator.getRawAxis(2);
  }

  public double getOperatorRightTrigger() {
    return operator.getRawAxis(3);
  }

  public boolean getOperatorLeftBumper() {
    return operator.getRawButton(5);
  }

  public boolean getOperatorRightBumper() {
    return operator.getRawButton(6);
  }

  public class XBoxRightTrigger extends Button {

    private final Joystick joystick;
  
    public XBoxRightTrigger(Joystick joystick) {
      this.joystick = joystick;
    }
  
    public boolean get() {
      return joystick.getRawAxis(3) > .25;
    } 
  }
  public class XBoxLeftTrigger extends Button {

    private final Joystick joystick;
  
    public XBoxLeftTrigger(Joystick joystick) {
      this.joystick = joystick;
    }
  
    public boolean get() {
      return joystick.getRawAxis(2) > .25;
    }  
  }

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    operator_rightBumper.toggleWhenPressed(new CollectPowerCells());
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
