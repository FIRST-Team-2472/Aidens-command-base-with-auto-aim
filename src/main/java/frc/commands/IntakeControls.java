

package frc.commands;
import java.util.function.Supplier;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeControls extends CommandBase{
    private Supplier<Boolean> conveyorButton, elevatorButton, flywheelButton;
    private Intake Intake;

    public IntakeControls(Supplier<Boolean> conveyorButton, Supplier<Boolean> elevatorButton, Supplier<Boolean> flywheelButton, Intake Intake) {
        this.conveyorButton = conveyorButton;
        this.elevatorButton = elevatorButton;
        this.flywheelButton = flywheelButton;
        this.Intake = Intake;
        addRequirements(Intake);
    }
    public void initialize() {
    }

    public void execute() {
        if(flywheelButton.get())
            Intake.controlsFlywheel(-1);
        else    
            Intake.controlsFlywheel(0);

        if(conveyorButton.get())
            Intake.controlsConveyor(1);
        else    
            Intake.controlsConveyor(0);

        if(elevatorButton.get())
            Intake.controlsElevator(1);
        //else if(eject.get()) 
        //Intake.controlsElevator(-1);
        else
            Intake.controlsElevator(0);
    }

    public void end(boolean interrupted) {
        Intake.controlsConveyor(0);
        Intake.controlsElevator(0);
        Intake.controlsFlywheel(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
