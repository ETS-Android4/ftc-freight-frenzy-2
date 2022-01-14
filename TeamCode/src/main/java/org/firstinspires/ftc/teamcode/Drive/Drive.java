package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Mecanum Drive", group="none")
public class Drive extends LinearOpMode {


    static DcMotor backRight;
    static DcMotor frontLeft;
    static DcMotor frontRight;
    static DcMotor backLeft;
    static DcMotor rightArm;
    static DcMotor leftArm;
    static Servo clawServo;

    @Override
    public void runOpMode(){
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        rightArm = hardwareMap.dcMotor.get("rightArm");
        leftArm = hardwareMap.dcMotor.get("leftArm");
        clawServo=hardwareMap.servo.get("clawServo");

        waitForStart();
        while (opModeIsActive()){
            double leftX = 0.7 * gamepad1.left_stick_x;
            double rightX = 0.7 * gamepad1.right_stick_x;
            double rightY = 0.7 * gamepad1.right_stick_y;
            double upDown = 0.4 * gamepad2.left_stick_y;

            backLeft.setPower(-rightX - rightY - leftX);
            backRight.setPower(-rightX + rightY - leftX);
            frontLeft.setPower(rightX - rightY - leftX);
            frontRight.setPower(rightX + rightY - leftX);
            rightArm.setPower(upDown);
            leftArm.setDirection(DcMotor.Direction.REVERSE);
            leftArm.setPower(upDown);

            if (gamepad2.x){
                clawServo.setPosition(1);
                //right bumber = fast arm raise
            }
            else {
                clawServo.setPosition(0.5);
            }

        }

    }

}
