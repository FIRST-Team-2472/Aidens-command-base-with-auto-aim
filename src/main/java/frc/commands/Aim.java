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
    DigitalInput LimitSwitch = new DigitalInput(0);
    turret turret;
    // Supplier<Double> yaw = () -> 0.0;
    // Supplier<Double> pitch = () -> 0.0;
    private GenericEntry tx;
    private GenericEntry ty;
    private GenericEntry ta;
    private GenericEntry x;
    private GenericEntry y;
    private GenericEntry z;
    private Pose3d tagPos = new Pose3d();
    LimelightHelpers.LimelightResults llresults;

    public Aim() {

        // public void ();
        initLimeLightShuffleBoard();

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // System.out.println("Yaw: " + yaw.get() + ", Pitch: " + pitch.get());
        llresults = LimelightHelpers.getLatestResults(null);
        if (llresults.targetingResults.targets_Fiducials.length > 0) {
            tagPos = llresults.targetingResults.targets_Fiducials[0].getTargetPose_CameraSpace();
        }

        tx.setDouble(LimelightHelpers.getTX(null));
        ty.setDouble(LimelightHelpers.getTY(null));

        x.setDouble(tagPos.getX());
        y.setDouble(tagPos.getY());
        z.setDouble(tagPos.getZ());

        System.out.println("Turret Yaw: " + turret.getYawPosition());
    }

    void initLimeLightShuffleBoard() {
        System.out.println("LimeLight Shuffleboard Starting");
        ShuffleboardTab limelightBoard = Shuffleboard.getTab("LimeLight");
        tx = limelightBoard.add("tx", 0).withPosition(3, 0).getEntry();
        ty = limelightBoard.add("ty", 0).withPosition(3, 1).getEntry();
        x = limelightBoard.add("x", 0).getEntry();
        y = limelightBoard.add("y", 0).getEntry();
        z = limelightBoard.add("z", 0).getEntry();
        limelightBoard.addCamera("LimeLight Stream", "limelight0", "mjpg:http://10.24.72.23:5800").withSize(3, 3);
        Shuffleboard.update();
    }

    public float[] convertToFloatArray(Pose3d pos) {
        float[] array = { (float) pos.getX(), (float) pos.getY(), (float) pos.getZ() };
        return array;
    }
}
