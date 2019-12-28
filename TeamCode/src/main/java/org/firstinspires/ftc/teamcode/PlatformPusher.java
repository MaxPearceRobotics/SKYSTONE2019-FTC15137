package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "platform pusher", group = "autonomous")

public class PlatformPusher extends LinearOpMode {

    // Declare OpMode members.
   private DcMotorEx MotorLeftFront;
   private DcMotorEx MotorRightFront;
   private DcMotorEx MotorLeftBack;
   private DcMotorEx MotorRightBack;
   private DcMotor MotorIntake1;
   private DcMotor MotorIntake2;
   private Servo platformMover1;
   private Servo platformMover2;

    //variables
    private double up = 1;
    private double down = 0;
    
    @Override
    public void runOpMode() {
        //Motors
        MotorLeftFront = (DcMotorEx)hardwareMap.dcMotor.get("MotorLeftFront");
        MotorRightFront =(DcMotorEx) hardwareMap.dcMotor.get("MotorRightFront");
        MotorLeftBack = (DcMotorEx)hardwareMap.dcMotor.get("MotorLeftBack");
        MotorRightBack =(DcMotorEx) hardwareMap.dcMotor.get("MotorRightBack");
        MotorRightFront.setDirection(DcMotor.Direction.REVERSE);
         MotorRightBack.setDirection(DcMotor.Direction.REVERSE);
        MotorIntake1 = hardwareMap.dcMotor.get("MotorIntake1");
        MotorIntake2 = hardwareMap.dcMotor.get("MotorIntake2");
        //Servos
      platformMover1 = hardwareMap.get(Servo.class, "pushyboy1");
      platformMover2 = hardwareMap.get(Servo.class, "pushyboy2");
      
      MotorLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
      MotorRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
      MotorLeftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
      MotorRightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        
    waitForStart();
    MovePlatform(up);
    MoveFoward(3500,0.75);
    sleep(3000);
    MovePlatform(down);
    sleep(2000);
    MoveFoward(-3500,0.75);
    sleep(2000);
    MovePlatform(down);
    sleep(500);
    MoveSideways(1000, 1);
    sleep(1000);
    
       }
       public void MoveFoward(int Position, double SpeedIsKey)
       {
        MotorLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          while(MotorLeftFront.getCurrentPosition() <Position && MotorRightFront.getCurrentPosition() <Position )
          {
              MotorLeftFront.setPower(SpeedIsKey);
              MotorRightFront.setPower(SpeedIsKey);
              MotorLeftBack.setPower(SpeedIsKey);
              MotorRightBack.setPower(SpeedIsKey);
          }
          MotorLeftFront.setPower(0);
          MotorRightFront.setPower(0);
          MotorLeftBack.setPower(0);
          MotorRightBack.setPower(0);
        }
        
    public void MoveSideways(int distance, double SpeedIsKey )
    {
         MotorLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while(MotorRightFront.getCurrentPosition()< distance && MotorRightBack.getCurrentPosition() > -distance)
        {
      MotorRightBack.setPower(-SpeedIsKey);
      MotorLeftBack.setPower(-SpeedIsKey);
      MotorLeftFront.setPower(SpeedIsKey);
      MotorRightFront.setPower(SpeedIsKey);  
        }
         MotorLeftFront.setPower(0);
         MotorRightFront.setPower(0);
         MotorLeftBack.setPower(0);
         MotorRightBack.setPower(0);
    }
        
    public void MovePlatform(double position)
    {
    platformMover1.setPosition(position);
    platformMover2.setPosition(position);
    }
   }