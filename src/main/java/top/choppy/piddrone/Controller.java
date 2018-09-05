package top.choppy.piddrone;

public interface Controller<OutputType> {
	int alpha = 100;
	
	public int getAlpha();	
	
	public void doTick(int angle);
	
}
