package top.choppy.piddrone;

public class PitchController implements Controller<Double> {
	public AngleTarget mode = AngleTarget.HOVER;
	Double alpha;
	Double targetPitch;

	public PitchController(AngleTarget mode) {
		this.mode = mode;
		alpha = mode.alpha();
		targetPitch = mode.target();
	}

	public void setMode(AngleTarget mode) {
		this.mode = mode;
	}

	public AngleTarget getMode() {
		return this.mode;
	}

	public Double getAlpha() {
		return alpha;
	}

	public void doTick(Double d) {
		Double currentPitch = d;

		PWMCorrection correction1 = new PWMCorrection(alpha * (currentPitch - targetPitch), Start.frontLeft);
		PWMCorrection correction2 = new PWMCorrection(alpha * (currentPitch - targetPitch), Start.frontRight);
		PWMCorrection correction3 = new PWMCorrection(-(alpha * (currentPitch - targetPitch)), Start.backLeft);
		PWMCorrection correction4 = new PWMCorrection(-(alpha * (currentPitch - targetPitch)), Start.backRight);

		correction1.correct();
		correction2.correct();
		correction3.correct();
		correction4.correct();

	}

}
