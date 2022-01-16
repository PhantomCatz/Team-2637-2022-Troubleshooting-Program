package frc.Mechanisms;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;;

public class TestMotors
{
    public CANSparkMax SparkMaxMTR;
    public WPI_TalonSRX TalonMTR;
    public WPI_VictorSPX VictorMTR;
    

    private final int SPARKMAX_MC_ID = -99999; 
    private final int TALON_MC_ID = 11; 
    private final int VICTOR_MC_ID = -99999; 

    private final double MTR_PWR = 0.3;

    private int testingMotor = 0;

    public TestMotors()
    {
        SparkMaxMTR = new CANSparkMax(SPARKMAX_MC_ID, MotorType.kBrushless);
        TalonMTR = new WPI_TalonSRX(TALON_MC_ID);
        VictorMTR = new WPI_VictorSPX(VICTOR_MC_ID);

        //Reset configuration
        SparkMaxMTR.restoreFactoryDefaults();
        TalonMTR.configFactoryDefault();
        VictorMTR.configFactoryDefault();

        //Set SparkMaxMTR to brake mode
        SparkMaxMTR.setIdleMode(IdleMode.kBrake);
    }

    public void testSparkMax()
    {
        if(testingMotor == 0)
        {
            testingMotor = 1;
        }
        SparkMaxMTR.set(MTR_PWR);
    }

    public void testTalonSRX()
    {
        if(testingMotor == 0)
        {
            testingMotor = 2;
        }
        TalonMTR.set(ControlMode.PercentOutput, MTR_PWR);
    }

    public void testVictorSPX()
    {
        if(testingMotor == 0)
        {
            testingMotor = 3;
        }
        VictorMTR.set(MTR_PWR);
    }

    public void stopMotor()
    {
        if(testingMotor == 1)
        {
            SparkMaxMTR.set(0.0);
        }
        else if(testingMotor == 2)
        {
            TalonMTR.set(0.0);
        }
        else if(testingMotor == 3)
        {
            VictorMTR.set(0.0);
        }
    }
}