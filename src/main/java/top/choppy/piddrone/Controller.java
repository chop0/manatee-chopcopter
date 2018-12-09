package top.choppy.piddrone;

public interface Controller<OutputType> {
	Double alpha = 100d;
	
	public OutputType getAlpha();	
	
	public void doTick(OutputType angle);
	
	
	
}
