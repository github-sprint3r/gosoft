package api.model;

import java.util.List;

import api.dao.FeeDAO;

public class ModelFee {
	String feeType;
	String startTime;
	String endTime;
	List<String> id;
	List<String> feeName;
	List<String> hourStart;
	List<String> hourEnd;
	List<String> feePerHour;
	private FeeDAO feeDAO;

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

	public FeeDAO getFreeDAO() {
		return feeDAO;
	}

	public void setFeeDAO(FeeDAO feeDAO) {
		this.feeDAO = feeDAO;
	}

	public FeeDAO getFeeDAO() {
		return feeDAO;
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

	public void inquiry() throws Exception {
		getFeeDAO().inquiry(this);	
	}

	public void save() throws Exception {
		if(checkData())
			getFeeDAO().save(this);
		else
			throw new Exception();
	}

	public boolean checkData() {
		for (int start = 0; start < getHourStart().size(); start++) {
			for (int end = 0; end < getHourEnd().size(); end++) {
				if(!getHourStart().get(start).equals("") || !getHourStart().get(end).equals("")) {
					if(start != end &&  !getHourStart().get(start).equals("") &&  !getHourStart().get(end).equals("")) {
						if(Integer.parseInt(getHourStart().get(start)) > Integer.parseInt(getHourStart().get(end)))
							if(Integer.parseInt(getHourStart().get(start)) <= Integer.parseInt(getHourEnd().get(end)))
								return false;
					}
				}
			}
		}
		return true;
	}
}
