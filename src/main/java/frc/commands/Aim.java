package frc.commands;

import java.util.function.Supplier;

import javax.sound.sampled.SourceDataLine;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.subsystems.turret;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class Aim extends CommandBase {
    DigitalInput limitswitch = new DigitalInput(0);
    private turret turret;
    Supplier<Double> yaw;
    Supplier<Double> pitch;
    

    public Aim(turret turret) {
        this.turret = turret;
        addRequirements(turret);
    }
    
    @Override
    public void initialize() {
        turret.controlsPitch(0.2);

        if(limitswitch.get()) {
            turret.controlsPitch(0);
            Supplier<Double> pitch = ()-> 0.0;
        }
    
        }

        
    

    @Override
    public void execute() {
    

        System.out.println("Yaw: " + yaw.get() + ", Pitch: " + pitch.get());
    }
    
}
