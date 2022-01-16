package frc.robot;

import java.util.ArrayList;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.kauailabs.navx.frc.AHRS;
import frc.Mechanisms.TestMotors;



public class Robot extends TimedRobot 
{
  public static TestMotors testmotors;

  public static PowerDistribution pdp;

  public static AHRS navx;
  
//-------------------------------------------Drive Controller------------------------------------------------------------- 
  public static XboxController xboxDrv;
  public static XboxController xboxAux;

  private final int XBOX_DRV_PORT = 0;
  private final int XBOX_AUX_PORT = 1;
  private final int DPAD_UP = 0;
  private final int DPAD_DN = 180;
  private final int DPAD_LT = 270;
  private final int DPAD_RT = 90;

  public int testMotorType;

  
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */

  @Override
  public void robotInit() 
  {
    xboxDrv = new XboxController(XBOX_DRV_PORT);
    xboxAux = new XboxController(XBOX_AUX_PORT);

    testmotors = new TestMotors();
  
    navx = new AHRS(Port.kMXP, (byte)200);
    navx.reset();
    
    pdp = new PowerDistribution();
    
  }

  @Override

  public void robotPeriodic() 
  {
    SmartDashboard.putNumber("Rotation", navx.getAngle());
  }

  @Override
  public void autonomousInit() 
  {
    
  }

  @Override
  public void autonomousPeriodic() 
  {


  }

  @Override
  public void teleopInit() 
  {
    System.out.println("X = SparkMax\nA = Talon\nY = Victor\nB = Stop Motor");
  }

  @Override
  public void teleopPeriodic() 
  {
    //-------------------------------------------Test Motor------------------------------------------------------------- 

    if(xboxDrv.getXButton())
    {
      testmotors.testSparkMax();
    }

    if(xboxDrv.getAButton())
    {
      testmotors.testTalonSRX();
    }

    if(xboxDrv.getYButton())
    {
      testmotors.testVictorSPX();
    }

    if(xboxDrv.getBButton())
    {
      testmotors.stopMotor();
    }

  }

  @Override
  public void disabledInit() 
  {
    
  }

  @Override
  public void disabledPeriodic() 
  {
  }

  @Override
  public void testInit() 
  {
  }

  @Override
  public void testPeriodic() 
  {
  }
}