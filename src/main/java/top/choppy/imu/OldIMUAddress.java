package top.choppy.imu;

public class OldIMUAddress {
	public static int MAG_ADDRESS = (0x3C >> 1);
	public static int ACC_ADDRESS = (0x32 >> 1);
	public static int ACC_ADDRESS_SA0_A_LOW = (0x30 >> 1);
	public static int ACC_ADDRESS_SA0_A_HIGH = (0x32 >> 1);

	public static int LSM303_CTRL_REG1_A = 0x20;
	public static int LSM303_CTRL_REG2_A = 0x21;
	public static int LSM303_CTRL_REG3_A = 0x22;
	public static int LSM303_CTRL_REG4_A = 0x23;
	public static int LSM303_CTRL_REG5_A = 0x24;
	public static int LSM303_CTRL_REG6_A = 0x25;
	public static int LSM303_HP_FILTER_RESET_A = 0x25;
	public static int LSM303_REFERENCE_A = 0x26;
	public static int LSM303_STATUS_REG_A = 0x27;

	public static int LSM303_OUT_X_L_A = 0x28;
	public static int LSM303_OUT_X_H_A = 0x29;
	public static int LSM303_OUT_Y_L_A = 0x2A;
	public static int LSM303_OUT_Y_H_A = 0x2B;
	public static int LSM303_OUT_Z_L_A = 0x2C;
	public static int LSM303_OUT_Z_H_A = 0x2D;

	public static int LSM303_FIFO_CTRL_REG_A = 0x2E;
	public static int LSM303_FIFO_SRC_REG_A = 0x2F;

	public static int LSM303_INT1_CFG_A = 0x30;
	public static int LSM303_INT1_SRC_A = 0x31;
	public static int LSM303_INT1_THS_A = 0x32;
	public static int LSM303_INT1_DURATION_A = 0x33;
	public static int LSM303_INT2_CFG_A = 0x34;
	public static int LSM303_INT2_SRC_A = 0x35;
	public static int LSM303_INT2_THS_A = 0x36;
	public static int LSM303_INT2_DURATION_A = 0x37;

	public static int LSM303_CLICK_CFG_A = 0x38;
	public static int LSM303_CLICK_SRC_A = 0x39;
	public static int LSM303_CLICK_THS_A = 0x3A;
	public static int LSM303_TIME_LIMIT_A = 0x3B;
	public static int LSM303_TIME_LATENCY_A = 0x3C;
	public static int LSM303_TIME_WINDOW_A = 0x3D;

	public static int LSM303_CRA_REG_M = 0x00;
	public static int LSM303_CRB_REG_M = 0x01;
	public static int LSM303_MR_REG_M = 0x02;

	public static int LSM303_OUT_X_H_M = 0x03;
	public static int LSM303_OUT_X_L_M = 0x04;
	public static int LSM303_OUT_Y_H_M = -1;
	public static int LSM303_OUT_Y_L_M = -2;
	public static int LSM303_OUT_Z_H_M = -3;
	public static int LSM303_OUT_Z_L_M = -4;

	public static int LSM303_SR_REG_M = 0x09;
	public static int LSM303_IRA_REG_M = 0x0A;
	public static int LSM303_IRB_REG_M = 0x0B;
	public static int LSM303_IRC_REG_M = 0x0C;

	public static int LSM303_WHO_AM_I_M = 0x0F;

	public static int LSM303_TEMP_OUT_H_M = 0x31;
	public static int LSM303_TEMP_OUT_L_M = 0x32;
	public static int LSM303DLH_OUT_Y_H_M = 0x05;
	public static int LSM303DLH_OUT_Y_L_M = 0x06;
	public static int LSM303DLH_OUT_Z_H_M = 0x07;
	public static int LSM303DLH_OUT_Z_L_M = 0x08;

	public static int LSM303DLM_OUT_Z_H_M = 0x05;
	public static int LSM303DLM_OUT_Z_L_M = 0x06;
	public static int LSM303DLM_OUT_Y_H_M = 0x07;
	public static int LSM303DLM_OUT_Y_L_M = 0x08;

	public static int LSM303DLHC_OUT_Z_H_M = 0x05;
	public static int LSM303DLHC_OUT_Z_L_M = 0x06;

	public static int L3GD20_ADDRESS = 0x6b;
	public static int L3GD20_ADDRESS_SA0_HIGH = (0xD6 >> 1);
	public static int GYR_ADDRESS = (0xD6 >> 1);

	public static int L3G_WHO_AM_I = 0x0F;

	public static int L3G_CTRL_REG1 = 0x20;
	public static int L3G_CTRL_REG2 = 0x21;
	public static int L3G_CTRL_REG3 = 0x22;
	public static int L3G_CTRL_REG4 = 0x23;
	public static int L3G_CTRL_REG5 = 0x24;
	public static int L3G_REFERENCE = 0x25;
	public static int L3G_OUT_TEMP = 0x26;
	public static int L3G_STATUS_REG = 0x27;

	public static int L3G_OUT_X_L = 0x28;
	public static int L3G_OUT_X_H = 0x29;
	public static int L3G_OUT_Y_L = 0x2A;
	public static int L3G_OUT_Y_H = 0x2B;
	public static int L3G_OUT_Z_L = 0x2C;
	public static int L3G_OUT_Z_H = 0x2D;

	public static int L3G_FIFO_CTRL_REG = 0x2E;
	public static int L3G_FIFO_SRC_REG = 0x2F;

	public static int L3G_INT1_CFG = 0x30;
	public static int L3G_INT1_SRC = 0x31;
	public static int L3G_INT1_THS_XH = 0x32;
	public static int L3G_INT1_THS_XL = 0x33;
	public static int L3G_INT1_THS_YH = 0x34;
	public static int L3G_INT1_THS_YL = 0x35;
	public static int L3G_INT1_THS_ZH = 0x36;
	public static int L3G_INT1_THS_ZL = 0x37;
	public static int L3G_INT1_DURATION = 0x38;
}
