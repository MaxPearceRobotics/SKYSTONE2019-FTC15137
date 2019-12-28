package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "DriveToLine", group = "A")
public class Drivetoline extends LinearOpMode {

    // Declare OpMode members.
    private DcMotorEx MotorLeftFront;
    private DcMotorEx MotorRightFront;
    private DcMotorEx MotorLeftBack;
    private DcMotorEx MotorRightBack;
    private DcMotor MotorIntake1;
    private DcMotor MotorIntake2;

    @Override
    public void runOpMode() {
        MotorLeftFront = (DcMotorEx) hardwareMap.dcMotor.get("MotorLeftFront");
        MotorRightFront = (DcMotorEx) hardwareMap.dcMotor.get("MotorRightFront");
        MotorLeftBack = (DcMotorEx) hardwareMap.dcMotor.get("MotorLeftBack");
        MotorRightBack = (DcMotorEx) hardwareMap.dcMotor.get("MotorRightBack");
        MotorRightFront.setDirection(DcMotor.Direction.REVERSE);
        MotorRightBack.setDirection(DcMotor.Direction.REVERSE);
        MotorIntake1 = hardwareMap.dcMotor.get("MotorIntake1");
        MotorIntake2 = hardwareMap.dcMotor.get("MotorIntake2");

        MotorLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        MotorRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        MotorLeftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        MotorRightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);


        waitForStart();
        MoveFoward(3500, 0.75);
        sleep(3000);

    }

    public void MoveFoward(int Position, double SpeedIsKey) {
        MotorLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //while (!(MotorLeftFront.getCurrentPosition() >= Position || !MotorRightFront.getCurrentPosition)) {

        //}
    }
}