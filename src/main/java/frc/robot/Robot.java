package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
//anything you want

  private final Spark mRightMaster = new Spark(0);
  private final Spark mRightSlave = new Spark(1);
  private final Spark mLeftMaster = new Spark(2);
  private final Spark mLeftSlave = new Spark(3);

  private final SpeedControllerGroup mLeftGroup  =  new SpeedControllerGroup(mLeftMaster, mLeftSlave);
  private final SpeedControllerGroup mRightGroup  =  new SpeedControllerGroup(mRightMaster, mRightSlave);

  private final DifferentialDrive mDrive = new DifferentialDrive(mLeftGroup, mRightGroup);
  private final Joystick m_stick = new Joystick(0);

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
    mDrive.arcadeDrive(-m_stick.getY(), m_stick.getZ());
  }

  @Override
  public void testPeriodic() {
  }
}