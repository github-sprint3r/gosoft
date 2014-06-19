package api.model;

public class SearchCriteria {
	private String carlicensetxt;
	private String provinceddl;
	
	public SearchCriteria(){
		
	}
	public SearchCriteria(String carlicensetxt, String provinceddl){
		this.carlicensetxt= carlicensetxt;
		this.provinceddl = provinceddl;
	}
	public String getCarlicensetxt() {
		return carlicensetxt;
	}
	public void setCarlicensetxt(String carlicensetxt) {
		this.carlicensetxt = carlicensetxt;
	}
	public String getProvinceddl() {
		return provinceddl;
	}
	public void setProvinceddl(String provinceddl) {
		this.provinceddl = provinceddl;
	}
}
