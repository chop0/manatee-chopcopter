package top.choppy.piddrone;

public class GyroThread implements Runnable {

	@Override
	public void run() {
		float rate_gyr_x;
		float rate_gyr_y;
		float rate_gyr_z;

		float DT = 0.02f;
		while (true) {
			try {
				rate_gyr_x = App.imu.getGyr()[0];
				rate_gyr_y = App.imu.getGyr()[1];
				rate_gyr_z = App.imu.getGyr()[2];
				App.gyroXangle += rate_gyr_x * DT;
				App.gyroYangle += rate_gyr_y * DT;
				App.gyroZangle += rate_gyr_z * DT;
				Thread.currentThread().sleep(20);
			} catch (Exception e) {
			}
		}
	}

}
