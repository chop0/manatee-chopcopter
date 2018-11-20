package top.choppy.piddrone;

import com.pi4j.io.gpio.GpioPinPwmOutput;

public class PWMCorrection implements Correction<Double> {
	
	Double correction;
	GpioPinPwmOutput pin;

	public PWMCorrection(Double d, GpioPinPwmOutput pin) {
		this.correction = d;
		this.pin = pin;
	}
	
	public void setCorrection(Double correction) {
		this.correction = correction;
		
	}

	public Double getCorrection() {
		return correction;
	}

	public void correct() {
		pin.setPwm((int) (pin.getPwm() + this.getCorrection()));
	}

}
