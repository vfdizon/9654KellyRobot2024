package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private CANSparkMax mMainShooter = new CANSparkMax(Constants.ShooterIDs.kShooterOne, MotorType.kBrushed);
    private CANSparkMax mFollowerShooter = new CANSparkMax(Constants.ShooterIDs.kShooterTwo, MotorType.kBrushed);

    public Shooter() {
        mMainShooter.setInverted(true);
        mFollowerShooter.setInverted(true);
    }

    public void runShooter(boolean isShooting, boolean isReversing) {

        if (isShooting) {
            mMainShooter.set(1);
            mFollowerShooter.set(1);
            System.out.println("SHOOTING");
        } else if(isReversing){
            mMainShooter.set(-0.25);
            mFollowerShooter.set(-0.25);
            System.out.println("REVERSING");
        }   else {
            mMainShooter.set(0);
            mFollowerShooter.set(0);
            System.out.println("SHOOTER IDLE");
        }
    }

    public void runTopMotor(double dc) {
        mMainShooter.set(dc);
    }

    public void runBottomMotor(double dc) {
        mFollowerShooter.set(dc);
    }
}
