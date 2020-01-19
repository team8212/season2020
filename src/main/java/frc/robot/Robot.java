package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.can.VictorSPX; 
import com.ctre.phoenix.motorcontrol.ControlMode; 

import frc.robot.Test;

public class Robot extends TimedRobot {

  public static Test test = new Test(); 

  private final VictorSPX mRightMaster = new VictorSPX(1);
  private final VictorSPX mRightSlave = new VictorSPX(2);
  private final VictorSPX mLeftMaster = new VictorSPX(3);
  private final VictorSPX mLeftSlave = new VictorSPX(4);

  

  private final VictorSPX mUpMaster = new VictorSPX(4);
  private final VictorSPX mUpSlave = new VictorSPX(5);

  private final Joystick m_stick = new Joystick(0);
  private final XboxController m_stick1 = new XboxController(0);

  @Override
  public void robotInit() { 
    CameraServer.getInstance().startAutomaticCapture();
  }
  @Override
  public void robotPeriodic() {}
  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() { }

  @Override
  public void teleopPeriodic() {
    //mDrive.arcadeDrive(-m_stick.getY(), m_stick.getZ());
    //mDrive.arcadeDrive(-m_stick1.getRawAxis(1), 
    
      RightMotors(m_stick.getY() + m_stick.getZ());
      LeftMotors(m_stick.getY() - m_stick.getZ());
  }

  @Override
  public void testPeriodic() {
  }
  public void RightMotors(double x) {

    mRightMaster.set(ControlMode.PercentOutput, x);
    mRightSlave.set(ControlMode.PercentOutput,x);
  }
  public void LeftMotors(double x){
    mLeftMaster.set(ControlMode.PercentOutput, x); 
    mLeftSlave.set(ControlMode.PercentOutput,x);
  }

}
