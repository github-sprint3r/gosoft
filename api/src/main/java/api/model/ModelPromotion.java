package api.model;

import api.dao.PromotionDAO;

public class ModelPromotion {
	String id;
	String feeType;
	String promotionName;
	String discountHours;
	String startTime;
	String endTime;

	PromotionDAO promotionDAO;
	
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
	
	public PromotionDAO getPromotionDAO() {
		return promotionDAO;
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

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getDiscountHours() {
		return discountHours;
	}

	public void setDiscountHours(String discountHours) {
		this.discountHours = discountHours;
	}

	public void setPromotionDAO(PromotionDAO promotionDAO) {
		this.promotionDAO = promotionDAO;
	}

	public void inquiry() throws Exception {
		getPromotionDAO().inquiry(this);

	}
	
	public void save() throws Exception {
		getPromotionDAO().save(this);

	}
}
