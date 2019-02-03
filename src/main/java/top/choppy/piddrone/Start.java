package top.choppy.piddrone;

import java.io.IOException;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import com.pi4j.io.i2c.impl.I2CBusImpl;
import com.pi4j.wiringpi.Gpio;

import top.choppy.imu.BNO055;
import top.choppy.imu.BNO055.OperationMode;
import top.choppy.imu.OldIMU;

public class Start {
	public static GpioController gpio = GpioFactory.getInstance();
	
	/*
	public static GpioPinPwmOutput frontLeft = gpio.provisionPwmOutputPin(RaspiPin.GPIO_11);
	public static GpioPinPwmOutput frontRight = gpio.provisionPwmOutputPin(RaspiPin.GPIO_12);
	public static GpioPinPwmOutput backLeft = gpio.provisionPwmOutputPin(RaspiPin.GPIO_13);
	public static GpioPinPwmOutput backRight = gpio.provisionPwmOutputPin(RaspiPin.GPIO_14);
*/
	public static GpioPinPwmOutput frontLeft = null;
	public static GpioPinPwmOutput frontRight = null;
	public static GpioPinPwmOutput backLeft = null;
	public static GpioPinPwmOutput backRight = null;
	public static GpioPinPwmOutput testMotor = gpio.provisionSoftPwmOutputPin(RaspiPin.GPIO_02);

	
	public static BNO055 imu;

	public static void main(String[] args) throws UnsupportedBusNumberException, IOException {
	//	imu = BNO055.getInstance(BNO055.OperationMode.OPERATION_MODE_IMUPLUS, BNO055.VectorType.VECTOR_EULER,
	//			I2CBusImpl.BUS_1);
		
Gpio.wiringPiSetup();
		if (true)
			while (true) {
				testMotor.setPwm(2000);
		//		System.out.print("\f" + (int)imu.getYaw() + ", " + (int)imu.getRoll() + ", " + (int)imu.getPitch());
			}

	

		frontLeft.setPwm(1250);
		frontRight.setPwm(1250);
		backLeft.setPwm(1250);
		backRight.setPwm(1250);

		new Thread(new Runnable() {

			@Override
			public void run() {
				PitchController pitchControl = new PitchController(AngleTarget.HOVER);
				while (true)
					pitchControl.doTick(imu.getPitch());

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				RollController rollControl = new RollController(AngleTarget.HOVER);
				while (true)
					rollControl.doTick(imu.getRoll());

			}
		}).start();

	}
}
