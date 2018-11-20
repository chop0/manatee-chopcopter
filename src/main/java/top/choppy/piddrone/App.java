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
import top.choppy.imu.OldIMU;

public class App {
	public static GpioController gpio = GpioFactory.getInstance();
	public static GpioPinPwmOutput frontLeft = gpio.provisionPwmOutputPin(RaspiPin.GPIO_11);
	public static GpioPinPwmOutput frontRight = gpio.provisionPwmOutputPin(RaspiPin.GPIO_12);
	public static GpioPinPwmOutput backLeft = gpio.provisionPwmOutputPin(RaspiPin.GPIO_13);
	public static GpioPinPwmOutput backRight = gpio.provisionPwmOutputPin(RaspiPin.GPIO_14);

	public static BNO055 imu;

	public static void main(String[] args) throws UnsupportedBusNumberException, IOException {
		imu = BNO055.getInstance(BNO055.OperationMode.OPERATION_MODE_IMUPLUS, BNO055.VectorType.VECTOR_EULER,
				I2CBusImpl.BUS_0);
		if (true)
			while (true) {
				System.out.println(imu.getPitch());
			}

		Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
		Gpio.pwmSetClock(50);
		Gpio.pwmSetRange(2000);

		frontLeft.setPwm(1250);
		frontRight.setPwm(1250);
		backLeft.setPwm(1250);
		backRight.setPwm(1250);

		PitchController pitchControl = new PitchController(AngleTarget.HOVER);
		RollController rollControl = new RollController(AngleTarget.HOVER);

		while (true) {
			pitchControl.doTick(imu.getPitch());
			rollControl.doTick(imu.getRoll());
		}

	}
}
