package top.choppy.piddrone;

public class RollController implements Controller<Double> {
	public AngleTarget mode = AngleTarget.HOVER;
	Double alpha;
	Double targetRoll;

	public RollController(AngleTarget mode) {
		this.mode = mode;
		alpha = mode.alpha();
		targetRoll = mode.target();
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
		double currentRoll = d;

		PWMCorrection correction1 = new PWMCorrection(alpha * (currentRoll - targetRoll), App.frontRight);
		PWMCorrection correction2 = new PWMCorrection(alpha * (currentRoll - targetRoll), App.frontRight);
		PWMCorrection correction3 = new PWMCorrection(-(alpha * (currentRoll - targetRoll)), App.backLeft);
		PWMCorrection correction4 = new PWMCorrection(-(alpha * (currentRoll - targetRoll)), App.backLeft);

		correction1.correct();
		correction2.correct();
		correction3.correct();
		correction4.correct();

	}

}
