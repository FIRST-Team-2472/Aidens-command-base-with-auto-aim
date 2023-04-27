package frc.robot.subsystems; 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;

public class drivetrain extends SubsystemBase {

    private TalonSRX left = new TalonSRX(constants.leftDriveTrainID);
    private TalonSRX right = new TalonSRX(constants.rightDriveTrainID);
    private TalonSRX Bleft = new TalonSRX(constants.leftDriveTrainID);
    private TalonSRX Bright = new TalonSRX(constants.rightDriveTrainID);

    public drivetrain(){
        Bleft.follow(left);
        Bright.follow(right);
    }
   

    public void tankDrive(double leftSpeed, double rightSpeed) {

        left.set(ControlMode.PercentOutput, leftSpeed);
        right.set(ControlMode.PercentOutput, rightSpeed);
        
    }

}
