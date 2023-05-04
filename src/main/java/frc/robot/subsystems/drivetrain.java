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
    MotorControllerGroup mGroupLeft = new MotorControllerGroup(left, Bleft);
    MotorControllerGroup mGroupRight = new MotorControllerGroup((MotorController)right,(MotorController) Bright);
    DifferentialDrive differentialMotors = new DifferentialDrive(mGroupLeft, mGroupRight);

    public drivetrain(){
      
    }
   
    public void arcadeDrive(double leftSpeed, double rightSpeed) {

        differentialMotors.arcadeDrive(leftSpeed, rightSpeed);
        
    }

}
