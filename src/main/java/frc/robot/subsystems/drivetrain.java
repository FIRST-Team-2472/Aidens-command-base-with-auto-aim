package frc.robot.subsystems; 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;

public class drivetrain extends SubsystemBase {

    private TalonSRX left = new TalonSRX(constants.leftDriveTrainID);
    private TalonSRX right = new TalonSRX(constants.rightDriveTrainID);
    private TalonSRX Bleft = new TalonSRX(constants.BleftDriveTrainID);
    private TalonSRX Bright = new TalonSRX(constants.BrightDriveTrainID);
   
    public drivetrain(){
      Bright.follow(right);
      Bleft.follow(left);
    }
   public void tankDrive(double y, double x){
    left.set(ControlMode.PercentOutput, y);
    right.set(ControlMode.PercentOutput, x);
   }

    public void arcadeDrive(double y, double x) {
        // y is the y axis of the joystick
        // x is the x axis of the SAME joystick
        if (Math.abs(x) < .1)
            x = 0;

        if (Math.abs(x) + Math.abs(y) < 1) {
            tankDrive(y - x, y + x);
        } else {
            // limits the motors from ever going over 75% speed
            double betterX = (x / (Math.abs(x) + Math.abs(y)));
            double betterY = (y / (Math.abs(x) + Math.abs(y)));
            tankDrive(betterY - betterX, betterY + betterX);
        }
    }

}
