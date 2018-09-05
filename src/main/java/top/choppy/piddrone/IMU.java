package top.choppy.piddrone;

import static top.choppy.piddrone.IMUAddress.*;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import com.pi4j.io.i2c.impl.I2CBusImpl;

public class IMU {

	float A_GAIN = 0.0573f;
	float G_GAIN = 0.070f;

	I2CBus bus;

	public static final byte[] intToByteArray(int value) {
		return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) value };
	}

	public IMU() throws UnsupportedBusNumberException, IOException {
		bus = I2CFactory.getInstance(I2CBusImpl.BUS_0);
		this.enableAccelerometer();
		this.enableGyroscope();
	}

	private void writeAccReg(int reg, byte value) throws IOException {
		I2CDevice device = bus.getDevice(ACC_ADDRESS);
		device.write(reg, value);
	}

	private void writeMagReg(int reg, byte value) throws IOException {
		I2CDevice device = bus.getDevice(MAG_ADDRESS);
		device.write(reg, value);
	}

	private void writeGyrReg(int reg, byte value) throws IOException {
		I2CDevice device = bus.getDevice(GYR_ADDRESS);
		device.write(reg, value);
	}

	 private void enableAccelerometer() throws IOException {
		writeAccReg(LSM303_CTRL_REG1_A, (byte) 0b01010111); // z,y,x axis enabled , 100Hz data rate
		writeAccReg(LSM303_CTRL_REG4_A, (byte) 0b00101000); // +/- 8G full scale: FS = 10 on DLHC, high resolution
															// output mode
	}

	 private void enableGyroscope() throws IOException {
		writeGyrReg(L3G_CTRL_REG1, (byte) 0b00001111); // Normal power mode, all axes enabled
		writeGyrReg(L3G_CTRL_REG4, (byte) 0b00110000); // Continuous update, 2000 dps full scale
	}

	int[] rawAcc() throws IOException {
		byte block[] = new byte[6];
		I2CDevice device = bus.getDevice(ACC_ADDRESS);
		device.read(0x80 | LSM303_OUT_X_L_A, block, 0, block.length);

		int vals[] = new int[3];
		// Combine readings for each axis.
		vals[0] = (int) (block[0] | block[1] << 8);
		vals[1] = (int) (block[2] | block[3] << 8);
		vals[2] = (int) (block[4] | block[5] << 8);
		return vals;
	}

	int[] rawGyr() throws IOException {
		byte block[] = new byte[6];
		I2CDevice device = bus.getDevice(GYR_ADDRESS);
		device.read(0x80 | L3G_OUT_X_L, block, 0, block.length);

		int vals[] = new int[3];
		// Combine readings for each axis.
		vals[0] = (int) (block[0] | block[1] << 8);
		vals[1] = (int) (block[2] | block[3] << 8);
		vals[2] = (int) (block[4] | block[5] << 8);
		return vals;
	}

	public float[] getGyr() throws IOException {
		int[] vals = rawGyr();
		
		float rate_gyr_x = (float) vals[0] * G_GAIN;
		float rate_gyr_y = (float) vals[1] * G_GAIN;
		float rate_gyr_z = (float) vals[2] * G_GAIN;
		
		float[] degreesPerSecond = new float[3];
		degreesPerSecond[0] = rate_gyr_x;
		degreesPerSecond[1] = rate_gyr_y;
		degreesPerSecond[2] = rate_gyr_z;
		
		return degreesPerSecond;
	}
	

}
