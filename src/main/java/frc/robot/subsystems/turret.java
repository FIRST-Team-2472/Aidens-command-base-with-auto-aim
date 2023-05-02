package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.constants;

public class turret {
    private TalonSRX pitch = new TalonSRX(constants.pitchMotorID);
    private TalonSRX yaw = new TalonSRX(constants.yawMotorID);
    private TalonSRX shooter = new TalonSRX(constants.shooterMotorID);
    
    

    public void controlsPitch(double pitch) {
        this.pitch.set(ControlMode.PercentOutput, pitch);
    }

    public void controlsYaw(double yaw) {      
        this.yaw.set(ControlMode.PercentOutput, yaw);
    }

    public void runShooter(double shooter) {
        this.shooter.set(ControlMode.PercentOutput, shooter);
    }
}