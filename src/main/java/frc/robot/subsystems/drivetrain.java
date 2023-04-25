package frc.robot.subsystems; 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;

public class drivetrain extends SubsystemBase {
    private TalonFX left = new TalonFX(constants.leftDriveTrainID);
    private TalonFX right = new TalonFX(constants.rightDriveTrainID);

    public void tankDrive(double leftSpeed, double rightSpeed) {

        left.set(ControlMode.PercentOutput, leftSpeed);
        right.set(ControlMode.PercentOutput, rightSpeed);
    }

}
