package top.choppy.piddrone;

public enum AngleTarget {
	HOVER(0, 100);

	private final int target; // in kilograms
	private final int alpha; // in meters

	AngleTarget(int target, int alpha) {
		this.target = target;
		this.alpha = alpha;
	}

	public int target() {
		return target;
	}

	public int alpha() {
		return alpha;
	}
}
