// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.drivetrain;
import frc.commands.Drive;
import frc.robot.subsystems.*;

public class RobotContainer {
  private final drivetrain drivetrain = new drivetrain();
  private final Joystick leftJoy = new Joystick(1);
  private final Joystick rightJoy = new Joystick(2);
  public RobotContainer() {

    drivetrain.setDefaultCommand(new Drive(drivetrain, () -> leftJoy.getX(), () -> rightJoy.getX()));
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
