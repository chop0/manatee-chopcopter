package top.choppy.piddrone;

public interface Correction<CorrectionType> {
	public void setCorrection(CorrectionType val);
	public CorrectionType getCorrection();
	public void correct();
}
