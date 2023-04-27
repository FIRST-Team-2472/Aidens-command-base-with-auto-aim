package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.constants;

public class turret {
    private TalonSRX pitch = new TalonSRX(constants.pitchMotorID);
}
