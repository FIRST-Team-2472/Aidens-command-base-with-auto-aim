package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;

public class turret extends SubsystemBase {
    private TalonSRX pitch = new TalonSRX(constants.pitchMotorID);
    private TalonSRX yaw = new TalonSRX(constants.yawMotorID);
    private TalonSRX shooter = new TalonSRX(constants.shooterMotorID);
    
    

    public void controlsPitch(double pitch) {
        this.pitch.set(ControlMode.PercentOutput, pitch * 0.4);
    }

    public void controlsYaw(double yaw) {      
        this.yaw.set(ControlMode.PercentOutput, yaw * 0.4);
    }

    public void runShooter(double shooter) {
        this.shooter.set(ControlMode.PercentOutput, shooter * 0.2);
    }
}