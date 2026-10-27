// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final PWMSparkMax motor = new PWMSparkMax(0);
  private final XboxController controller = new XboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  // Commands to move motor
  Command MotorMovement_1 = Commands.runEnd(()-> motor.setVoltage(6.0), () -> motor.setVoltage(6.0));
  Command MotorMovement_2 = Commands.runEnd(()-> motor.setVoltage(-6.0), () -> motor.setVoltage(0.0));

  private void configureBindings() {

    // Joystick of controller to move motors
    new JoystickButton(controller, 1);
    new JoystickButton(controller, 2);

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
