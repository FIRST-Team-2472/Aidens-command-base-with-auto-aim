package frc.commands;

import java.util.function.Supplier;

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
        jeffery.arcadeDrive(left.get()/2, right.get()/2);
    }

    public void end(boolean interrupted) {
        jeffery.arcadeDrive(0,0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
