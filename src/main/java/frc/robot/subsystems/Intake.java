package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;
public class Intake extends SubsystemBase {
    private TalonSRX elevator = new TalonSRX(constants.intakeElevatorID);
    private TalonSRX flywheel = new TalonSRX(constants.intakeMotorID);
    private TalonSRX conveyor = new TalonSRX(constants.intakeCoveyorID);

    public void controlsElevator(double elevatorSpeed) {
        elevator.set(ControlMode.PercentOutput, elevatorSpeed);
    }   

    public void controlsFlywheel(double flywheelSpeed) {
        flywheel.set(ControlMode.PercentOutput, flywheelSpeed);
    }
    
    public void controlsConveyor(double conveyorSpeed) {
        conveyor.set(ControlMode.PercentOutput, conveyorSpeed);
    }
}
