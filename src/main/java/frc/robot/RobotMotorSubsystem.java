// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.VoltageConfigs;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.overture.lib.motorcontrollers.OverTalonFX;

import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RobotMotorSubsystem extends SubsystemBase {

  // Roller Constants PRUEBA
  public class RollerConstants {

    public static Voltage OffVoltage = Volts.of(0.0);
    public static Voltage IntakingVoltage = Volts.of(8);
    public static Voltage OutTakingVoltage = Volts.of(-4);

    public static Voltage CompressingVoltage = Volts.of(2.5);

    public static int motorCanId = 32;

    public static final double GearRatio = (1/1);

    public static TalonFXConfiguration motorConfig() {
      return new TalonFXConfiguration()
        .withCurrentLimits(
          new CurrentLimitsConfigs()
            .withStatorCurrentLimitEnable(true)
            .withStatorCurrentLimit(100)
            .withSupplyCurrentLimitEnable(true)
            .withSupplyCurrentLimit(40))

          .withVoltage(
						new VoltageConfigs()
								.withPeakForwardVoltage(12)
								.withPeakReverseVoltage(-12))

				  .withMotorOutput(
						new MotorOutputConfigs()
								.withInverted(InvertedValue.Clockwise_Positive)
								.withNeutralMode(NeutralModeValue.Coast))
                
				  .withFeedback(
						new FeedbackConfigs()
								.withSensorToMechanismRatio(GearRatio));
    }

  }

  // Código bueno
  protected OverTalonFX MainMotor;

  /** Creates a new RobotMotorSubsystem. */
  public RobotMotorSubsystem() {

    MainMotor = new OverTalonFX(null, 0, null);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
