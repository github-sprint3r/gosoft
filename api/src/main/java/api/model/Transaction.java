package api.model;

import java.util.Date;

public class Transaction {

	private String carlicense;
	private int provinceid;
	private String startdatetxt;
	private String enddatetxt;
	private int netpricetxt;
	private int discountpricetxt;
	
	private String totalhourtxt;
	private int daytimehour;
	private int nighttimehour;
	
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
	public int getNetpricetxt() {
		return netpricetxt;
	}
	public void setNetpricetxt(int netpricetxt) {
		this.netpricetxt = netpricetxt;
	}
	public String getTotalhourtxt() {
		return totalhourtxt;
	}
	public void setTotalhourtxt(String totalhourtxt) {
		this.totalhourtxt = totalhourtxt;
	}
	public int getDaytimehour() {
		return daytimehour;
	}
	public void setDaytimehour(int daytimehour) {
		this.daytimehour = daytimehour;
	}
	public int getNighttimehour() {
		return nighttimehour;
	}
	public void setNighttimehour(int nighttimehour) {
		this.nighttimehour = nighttimehour;
	}
	public int getDiscountpricetxt() {
		return discountpricetxt;
	}
	public void setDiscountpricetxt(int discountpricetxt) {
		this.discountpricetxt = discountpricetxt;
	}
	
}
