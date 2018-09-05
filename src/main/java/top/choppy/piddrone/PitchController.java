package top.choppy.piddrone;

public class PitchController implements Controller<Integer> {
	public AngleTarget mode = AngleTarget.HOVER;
	int alpha;
	int targetPitch;

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

	public int getAlpha() {
		return alpha;
	}

	public void doTick(int angle) {
		int currentPitch = angle;

		PWMCorrection correction1 = new PWMCorrection(alpha * (currentPitch - targetPitch), App.frontLeft);
		PWMCorrection correction2 = new PWMCorrection(alpha * (currentPitch - targetPitch), App.frontRight);
		PWMCorrection correction3 = new PWMCorrection(-(alpha * (currentPitch - targetPitch)), App.backLeft);
		PWMCorrection correction4 = new PWMCorrection(-(alpha * (currentPitch - targetPitch)), App.backRight);

		correction1.correct();
		correction2.correct();
		correction3.correct();
		correction4.correct();

	}

}
