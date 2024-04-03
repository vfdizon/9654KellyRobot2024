package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShootCommand extends Command {
    private Shooter mShooter;
    private DoubleSupplier mShootTrigger;
    private BooleanSupplier mWindUpButton;
    private DoubleSupplier mIntakeTrigger; 

    public ShootCommand(Shooter shooter, DoubleSupplier shootTrigger, BooleanSupplier windUpButton, DoubleSupplier intakeTrigger) {
        mShooter = shooter;
        addRequirements(shooter);

        mShootTrigger = shootTrigger;
        mWindUpButton = windUpButton;
        mIntakeTrigger = intakeTrigger;

    }

    @Override 
    public void execute() {
        boolean isShooting = mShootTrigger.getAsDouble() >= 0.5;
        boolean isIntaking = mIntakeTrigger.getAsDouble() >= 0.5;
        boolean isWinding = mWindUpButton.getAsBoolean();

        if(isIntaking) {
            mShooter.runBottomMotor(-1);
            mShooter.runTopMotor(-1);
        }

        if(isWinding && !isShooting) {
            mShooter.runTopMotor(1);
            mShooter.runBottomMotor(0);
        } else if(isShooting && isWinding) {
            mShooter.runBottomMotor(1);
            mShooter.runTopMotor(1);
        } else if (!isIntaking) {
            mShooter.runTopMotor(0);
            mShooter.runBottomMotor(0);
        }

    }
}
