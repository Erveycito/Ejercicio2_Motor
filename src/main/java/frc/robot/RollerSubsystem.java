package frc.robot.RollerSubsystem;

// IMPORTS
import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.controls.VoltageOut;
import com.overture.lib.motorcontrollers.*;

import edu.wpi.first.units.measure.Voltage;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.*;

public class RollerSubsystem {
    
    protected OverTalonFX rollerLeadMotor;
    protected OverTalonFX rollerSlaveMotor;
    private Voltage target = Volts.of(0.0);

    protected final VoltageOut voltageRequest = new VoltageOut(0.0);

    public Roller() {
        
        rollerLeadMotor = new OverTalonFX(null, 0, null);
        rollerSlaveMotor = new OverTalonFX(null, 0, null);

        rollerSlaveMotor.setFollow(0, true);

    }

    public void setTarget(Voltage targetSetter) {
        target = targetSetter;
        rollerLeadMotor.setControl(voltageRequest.withOutput(target));
    }

    public double getTarget() {
        return target.baseUnitMagnitude();
    }

    public Command setVoltage(Voltage volts) {
        return runOnce(() -> {
            setTarget(volts)
        });
    }

    public double getVoltage() {
        return rollerLeadMotor.getMotorVoltage().getValueAsDouble();
    }

    public double getVelocity() {
        return rollerLeadMotor.getVelocity().getValueAsDouble();
    }

    public void updateTelemetry() {

    }

    @Override
    public void periodic() {
        
    }

}