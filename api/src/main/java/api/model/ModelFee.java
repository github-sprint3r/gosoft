package api.model;

import java.util.List;

public class ModelFee {
	String feeType;
	List<String> id;
	List<String> feeName;
	List<String> hourStart;
	List<String> hourEnd;
	List<String> feePerHour;

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public List<String> getId() {
		return id;
	}

	public void setId(List<String> id) {
		this.id = id;
	}

	public List<String> getFeeName() {
		return feeName;
	}

	public void setFeeName(List<String> feeName) {
		this.feeName = feeName;
	}

	public List<String> getHourStart() {
		return hourStart;
	}

	public void setHourStart(List<String> hourStart) {
		this.hourStart = hourStart;
	}

	public List<String> getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(List<String> hourEnd) {
		this.hourEnd = hourEnd;
	}

	public List<String> getFeePerHour() {
		return feePerHour;
	}

	public void setFeePerHour(List<String> feePerHour) {
		this.feePerHour = feePerHour;
	}

}
