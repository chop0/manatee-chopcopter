package top.choppy.piddrone;

import com.pi4j.io.gpio.GpioPinPwmOutput;

public class PWMCorrection implements Correction<Integer> {
	
	Integer correction;
	GpioPinPwmOutput pin;

	public PWMCorrection(Integer correction, GpioPinPwmOutput pin) {
		this.correction = correction;
		this.pin = pin;
	}
	
	public void setCorrection(Integer correction) {
		this.correction = correction;
		
	}

	public Integer getCorrection() {
		return correction;
	}

	public void correct() {
		pin.setPwm(pin.getPwm() + this.getCorrection());
	}

}
