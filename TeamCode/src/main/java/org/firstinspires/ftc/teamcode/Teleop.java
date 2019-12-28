package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;




@TeleOp(name = "Teleop", group = "A")
public class Teleop extends LinearOpMode {

    // Declare OpMode members.
    //Motors
    private DcMotor MotorLeftFront;
    private DcMotor MotorRightFront;
    private DcMotor MotorLeftBack;
    private DcMotor MotorRightBack;
    private DcMotorSimple MotorIntake1;
    private DcMotorSimple MotorIntake2;
    //Servos
    private Servo platformMover1;
    private Servo platformMover2;

    //variables
    private double up = 1;
    private double down = 0;

    @Override
    public void runOpMode() {
        //Motors
        MotorLeftFront = hardwareMap.dcMotor.get("MotorLeftFront");
        MotorRightFront = hardwareMap.dcMotor.get("MotorRightFront");
        MotorLeftBack = hardwareMap.dcMotor.get("MotorLeftBack");
        MotorRightBack = hardwareMap.dcMotor.get("MotorRightBack");

        MotorIntake1 = hardwareMap.get(DcMotorSimple.class, "MotorIntake1");
        MotorIntake2 = hardwareMap.get(DcMotorSimple.class, "MotorIntake2");

        //Servos
        platformMover1 = hardwareMap.get(Servo.class, "pushyboy1");
        platformMover2 = hardwareMap.get(Servo.class, "pushyboy2");


        waitForStart();
        while (opModeIsActive()) {
            //DriveTrain Code
            //forward and back
            MotorRightBack.setPower(gamepad1.left_stick_y);
            MotorLeftBack.setPower(-gamepad1.left_stick_y);
            MotorLeftFront.setPower(-gamepad1.left_stick_y);
            MotorRightFront.setPower(gamepad1.left_stick_y);
        }
    }
}