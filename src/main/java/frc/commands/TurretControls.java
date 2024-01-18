package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turret;
import frc.robot.subsystems.Intake;
import java.util.function.Supplier;

import edu.wpi.first.util.sendable.Sendable;
public class TurretControls extends CommandBase {
    private Supplier<Double> yaw, pitch;
    private Supplier<Boolean> shooter, eject;
    private turret turret;
    public TurretControls(Supplier<Double> yaw, Supplier<Double> pitch, Supplier<Boolean> shooter, Supplier<Boolean> eject, turret turret){
        this.yaw = yaw;
        this.pitch = pitch;
        this.shooter = shooter;
        this.turret = turret;
        this.eject = eject;
        addRequirements(turret);
    }

    public void initialize() {
    }

    public void execute() {
        turret.controlsYaw(yaw.get());
        turret.controlsPitch(pitch.get());
        if(shooter.get())
            turret.runShooter(1);
        else if(eject.get()){   
            turret.runShooter(-1);
        }else 
        turret.runShooter(0);
    }

    public void end(boolean interrupted) {
        turret.controlsYaw(0);
        turret.controlsPitch(0);
        turret.runShooter(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}