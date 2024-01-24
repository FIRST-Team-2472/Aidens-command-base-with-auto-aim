package frc.commands;

import java.util.function.Supplier;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.LimelightHelpers;
import frc.robot.subsystems.turret;

public class Aim extends CommandBase {
    DigitalInput limitswitch = new DigitalInput(0);
    boolean calibrating;
    private turret turret;
    Supplier<Double> yaw;
    Supplier<Double> pitch;
    private GenericEntry tx;
    private GenericEntry ty;
    private GenericEntry ta;
    private GenericEntry x;
    private GenericEntry y;
    private GenericEntry z;
    private Pose3d tagPos = new Pose3d();
    LimelightHelpers.LimelightResults llresults;

    public Aim(turret turret) {
        this.turret = turret;
        addRequirements(turret);

        // public void ();
        initLimeLightShuffleBoard();

    }

    @Override
    public void initialize() {
      calibrating = true;
    }

    @Override
    public void execute() {
        // System.out.println("Yaw: " + yaw.get() + ", Pitch: " + pitch.get());
        if (calibrating) {
            turret.controlsPitch(-0.3);
            calibrate();
        }

        llresults = LimelightHelpers.getLatestResults("limelight-shooter");
        if (llresults.targetingResults.targets_Fiducials.length > 0) {
            tagPos = llresults.targetingResults.targets_Fiducials[0].getTargetPose_CameraSpace();
        }

        tx.setDouble(LimelightHelpers.getTX("limelight-shooter"));
        ty.setDouble(LimelightHelpers.getTY("limelight-shooter"));

        x.setDouble(tagPos.getX());
        y.setDouble(tagPos.getY());
        z.setDouble(tagPos.getZ());

        System.out.println("Turret Yaw: " + turret.getPitchPosition());
    }

    void initLimeLightShuffleBoard() {
        System.out.println("LimeLight Shuffleboard Starting");
        ShuffleboardTab limelightBoard = Shuffleboard.getTab("LimeLight");
        tx = limelightBoard.add("tx", 0).withPosition(3, 0).getEntry();
        ty = limelightBoard.add("ty", 0).withPosition(3, 1).getEntry();
        x = limelightBoard.add("x", 0).getEntry();
        y = limelightBoard.add("y", 0).getEntry();
        z = limelightBoard.add("z", 0).getEntry();
        limelightBoard.addCamera("LimeLightShooter Stream", "limelight_shooter", "mjpg:http://limelight-shooter.local:5800").withSize(3, 3);
        Shuffleboard.update();
    }

    public float[] convertToFloatArray(Pose3d pos) {
        float[] array = { (float) pos.getX(), (float) pos.getY(), (float) pos.getZ() };
        return array;
    }

    private void calibrate() {
        if(!limitswitch.get()) {
            turret.controlsPitch(0);
            Supplier<Double> pitch = ()-> 0.0;
            calibrating = false;
            turret.setPitch(0.0);
        }
    }
}
