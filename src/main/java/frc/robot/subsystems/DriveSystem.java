package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSystem extends SubsystemBase {
    private CANSparkMax mFrontLeft;
    private CANSparkMax mFrontRight;
    private CANSparkMax mBackLeft;
    private CANSparkMax mBackRight;

    public DriveSystem() {
        mFrontLeft = new CANSparkMax(Constants.DriveIDs.kFrontLeft, MotorType.kBrushed);
        mFrontRight = new CANSparkMax(Constants.DriveIDs.kFrontRight, MotorType.kBrushed);
        mBackLeft = new CANSparkMax(Constants.DriveIDs.kBackLeft, MotorType.kBrushed);
        mBackRight = new CANSparkMax(Constants.DriveIDs.kBackRight, MotorType.kBrushed);

        mBackRight.setInverted(true);
        mFrontRight.setInverted(true);
        mFrontLeft.setInverted(false);
        mBackLeft.setInverted(false);
    }

    public void driveTank(double leftVoltage, double rightVoltage) {
        mBackLeft.set(leftVoltage);
        mFrontLeft.set(leftVoltage);

        mBackRight.set(rightVoltage);
        mFrontRight.set(rightVoltage);

        System.out.println("drive voltage: " + leftVoltage + " :: " + rightVoltage);
    }

}
