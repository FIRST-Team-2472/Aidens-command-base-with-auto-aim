// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.drivetrain;
import frc.commands.Drive;
import frc.commands.IntakeControls;
import frc.commands.TurretControls;
import frc.robot.subsystems.*;

public class RobotContainer {
  private final drivetrain drivetrain = new drivetrain();
  private final turret turret = new turret();
  private final Joystick leftJoy = new Joystick(1);
  private final Joystick rightJoy = new Joystick(2);
  public static XboxController Xboxcontroller = new XboxController(0);
  private final Intake intake = new Intake();
  public RobotContainer() {

    drivetrain.setDefaultCommand(new Drive(drivetrain, () -> leftJoy.getX(), () -> leftJoy.getY()));
    configureBindings();
    turret.setDefaultCommand(new TurretControls(()-> Xboxcontroller.getRightX(),  ()-> Xboxcontroller.getLeftY(), ()-> Xboxcontroller.getRightBumper(),()-> leftJoy.getRawButton(2), turret));
    intake.setDefaultCommand(new IntakeControls(()-> rightJoy.getRawButton(1),()-> Xboxcontroller.getRightBumper(),() -> rightJoy.getRawButton(1),()-> leftJoy.getRawButton(2), intake));
  }

  private void configureBindings() {}
  
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
