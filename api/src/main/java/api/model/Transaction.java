package api.model;

import java.util.Date;

public class Transaction {

	private String carlicense;
	private int provinceid;
	private Date startdate;
	private Date enddate;
	private String startdatetext;
	private String enddatetext;
	
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
	public String getStartdatetext() {
		return startdatetext;
	}
	public void setStartdatetext(String startdatetext) {
		this.startdatetext = startdatetext;
	}
	public String getEnddatetext() {
		return enddatetext;
	}
	public void setEnddatetext(String enddatetext) {
		this.enddatetext = enddatetext;
	}
	
}
