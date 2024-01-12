package frc.commands;

import java.util.function.Supplier;

import javax.sound.sampled.SourceDataLine;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Aim extends CommandBase {
    Supplier<Double> yaw = () -> 0.0;
    Supplier<Double> pitch = () -> 0.0;

    public Aim() {
        
    }

    @Override
    public void execute() {

        System.out.println("Yaw: " + yaw.get() + ", Pitch: " + pitch.get());
    }
    
}
