package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSystem;

public class DriveCommand extends Command {
    private DoubleSupplier mLeftDC;
    private DoubleSupplier mRightDC;
    private DriveSystem mDriveSystem;

    public DriveCommand(DriveSystem driveSystem, DoubleSupplier leftDC, DoubleSupplier rightDC) {
        mDriveSystem = driveSystem;
        addRequirements(driveSystem);

        mLeftDC = leftDC;
        mRightDC = rightDC;
    }

    @Override 
    public void execute() {
        double leftDC = mRightDC.getAsDouble();
        double rightDC = mLeftDC.getAsDouble();

        if(Math.abs(leftDC) < 0.05) {
            leftDC = 0;
        }

        if(Math.abs(rightDC) < 0.05) {
            rightDC = 0;
        }

        mDriveSystem.driveTank(leftDC, rightDC);
    }
    
}
