package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;

public class turret extends SubsystemBase {
    private TalonSRX pitch = new TalonSRX(constants.pitchMotorID);
    private TalonSRX yaw = new TalonSRX(constants.yawMotorID);
    private TalonSRX shooter = new TalonSRX(constants.shooterMotorID);
    private GenericEntry display;

    
    public turret () {
        shooter.configFactoryDefault();
        ShuffleboardTab programmerBoard = Shuffleboard.getTab("Programmer Board");
        display = programmerBoard.add("Yaw angle", 0).getEntry();
        setYaw(0);
    }
    public void setYaw(double angle) {
        yaw.setSelectedSensorPosition(angle);
    }
    public double getYawPosition(){
        return yaw.getSelectedSensorPosition();
    }

    public void controlsPitch(double pitch) {
        this.pitch.set(ControlMode.PercentOutput, pitch * 0.4);
    }

    public void controlsYaw(double yaw) {      
        this.yaw.set(ControlMode.PercentOutput, yaw * -0.4);
    }

    public void runShooter(double shooter) {
        this.shooter.set(ControlMode.PercentOutput, shooter *-1);
    }

    @Override
    public void periodic() {
        display.setDouble(getYawPosition());
    }
}