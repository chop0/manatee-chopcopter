package top.choppy.piddrone;

public enum AngleTarget {
	/**
	 * In a hovering position
	 */
	HOVER(0d, 100d);

	private final Double target; // in kilograms
	private final Double alpha; // in metres

	AngleTarget(Double target, Double alpha) {
		this.target = target;
		this.alpha = alpha;
	}

	
	public Double target() {
		return target;
	}

	public Double alpha() {
		return alpha;
	}
}
