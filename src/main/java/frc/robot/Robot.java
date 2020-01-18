package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// Comment time

public class Robot extends TimedRobot {
  // this is a comment

  private final Spark mRightMaster = new Spark(0);
  private final Spark mRightSlave = new Spark(1);
  private final Spark mLeftMaster = new Spark(2);
  private final Spark mLeftSlave = new Spark(3);

  private final Spark mUpMaster = new Spark(4);
  private final Spark mUpSlave = new Spark(5);
  private final Spark mDownMaster = new Spark(6);
  private final Spark mDownSlave = new Spark(7);

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
    int x = 0; 
    //m_stick.getRawButton(1)
    // mUpMaster.set(x); 
    if(m_stick.getRawButton(1))
    {
      mUpMaster.set(1);
    }
    else if(m_stick.getRawButton(2))
    {
      mDownMaster.set(-1);
    }
    else 
    {
      mDownMaster.set(0);
    }
  }

  @Override
  public void testPeriodic() {
  }
}
