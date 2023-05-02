package frc.commands;

import java.util.function.Supplier;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain;

public class Drive extends CommandBase {
    private drivetrain jeffery;
    private Supplier<Double> left, right;

    public Drive(drivetrain goober, Supplier<Double> left, Supplier<Double> right){
        jeffery = goober;
        this.left = left;
        this.right = right;
        addRequirements(jeffery);
    }

    public void initialize() {
    }

    public void execute() {
        jeffery.tankDrive(left.get(), right.get());
    }

    public void end(boolean interrupted) {
        jeffery.tankDrive(0,0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
