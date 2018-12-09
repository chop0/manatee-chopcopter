package top.choppy.piddrone;

public class AccelerationController implements Controller<double[]> {
	public AccelTarget mode = AccelTarget.HOVER;
	double[] alpha;
	double[] target;
	boolean lastHoverTick = false;
	
	public AccelerationController(AccelTarget mode) {
		this.mode = mode;
		alpha = mode.alpha();
		target = mode.target();

	}

	public void setMode(AccelTarget mode) {
		this.mode = mode;
		alpha = mode.alpha();
		target = mode.target();
	}

	public AccelTarget getMode() {
		return this.mode;
	}

	public double[] getAlpha() {
		return alpha;
	}

	public void doTick(double[] d) {
		double[] currentAccel = d;

		switch (mode) {
		case HOVER:
			if(lastHoverTick ) {
			PWMCorrection correction1 = new PWMCorrection(alpha[1] * (currentAccel[1] - target[1]),
					Start.frontLeft);
			PWMCorrection correction2 = new PWMCorrection(alpha[1] * (currentAccel[1] - target[1]),
					Start.frontRight);
			PWMCorrection correction3 = new PWMCorrection(alpha[1] * (currentAccel[1] - target[1]),
					Start.backLeft);
			PWMCorrection correction4 = new PWMCorrection(alpha[1] * (currentAccel[1] - target[1]),
					Start.backRight);
			correction1.correct();
			correction2.correct();
			correction3.correct();
			correction4.correct();
			lastHoverTick = !lastHoverTick;
			} else {
				PWMCorrection correction1 = new PWMCorrection(-alpha[1] * (currentAccel[1] - target[1]),
						Start.frontLeft);
				PWMCorrection correction2 = new PWMCorrection(-alpha[1] * (currentAccel[1] - target[1]),
						Start.frontRight);
				PWMCorrection correction3 = new PWMCorrection(-alpha[1] * (currentAccel[1] - target[1]),
						Start.backLeft);
				PWMCorrection correction4 = new PWMCorrection(-alpha[1] * (currentAccel[1] - target[1]),
						Start.backRight);
				correction1.correct();
				correction2.correct();
				correction3.correct();
				correction4.correct();
				lastHoverTick = !lastHoverTick;
			}
			break;
		}
	

	}

}
