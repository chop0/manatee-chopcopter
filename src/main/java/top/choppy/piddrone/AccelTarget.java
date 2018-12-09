package top.choppy.piddrone;

public enum AccelTarget {
	
	
	
	HOVER(new double[] {10, 10, 10}, new double[] {50,20,50}),
	LEFT(new double[] {1, 0, 0}, new double[] {50,20,50}),
	RIGHT(new double[] {-1, 0, 0}, new double[] {50,20,50}),
	UP(new double[] {0, 1, 0}, new double[] {50,20,50}),
	DOWN(new double[] {0, -1, 0}, new double[] {50,20,50}),
	FORWARD(new double[] {0, 0, 1}, new double[] {50,20,50}),
	BACKWARD(new double[] {0, 0, -1}, new double[] {50,20,50});
	

	
	
	private final double[] target; // in kilograms
	private final double[] alpha; // in metres

	AccelTarget(double[] target, double[] alpha) {
			this.target = target;
			this.alpha = alpha;
		}

	public double[] target() {
		return target;
	}

	public double[] alpha() {
		return alpha;
	}
}
