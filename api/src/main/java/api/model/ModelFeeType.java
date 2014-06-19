package api.model;

public class ModelFeeType {
	String id;
	String feeType;
	String feeTypeName;
	String startTime;
	String endTime;
	FeeTypeDAOStub feeTypeDAOStub;
	
	public FeeTypeDAOStub getFeeTypeDAOStub() {
		return feeTypeDAOStub;
	}
	public void setFeeTypeDAOStub(FeeTypeDAOStub feeTypeDAOStub) {
		this.feeTypeDAOStub = feeTypeDAOStub;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeTypeName() {
		return feeTypeName;
	}
	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public void setFeeTypeDAO(FeeTypeDAOStub feeTypeDAOStub) {
		setFeeTypeDAOStub(feeTypeDAOStub);
		
	}
	public void inquiry() {
		getFeeTypeDAOStub().inquiry(this);
		
	}
}
