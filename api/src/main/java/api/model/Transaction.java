package api.model;

import java.util.Date;

public class Transaction {

	private String carlicense;
	private int provinceid;
	private Date startdate;
	private Date enddate;
	private String startdatetxt;
	private String enddatetxt;
	
	public String getCarlicense() {
		return carlicense;
	}
	public void setCarlicense(String carlicense) {
		this.carlicense = carlicense;
	}
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getStartdatetxt() {
		return startdatetxt;
	}
	public void setStartdatetxt(String startdatetxt) {
		this.startdatetxt = startdatetxt;
	}
	public String getEnddatetxt() {
		return enddatetxt;
	}
	public void setEnddatetxt(String enddatetxt) {
		this.enddatetxt = enddatetxt;
	}
	
}
