package api.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import api.dao.FeeTypeDAO;

public class ModelFeeTypeTest {
	
	@Test
	public void testInputDAYTIMEThenReturn1000And0200() throws Exception {
		ModelFeeType modelFeeType = new ModelFeeType();
		FeeTypeDAO feeTypeDAOStub = new FeeTypeDAO (){
			public void inquiry(ModelFeeType modelFeeType) {
				modelFeeType.setStartTime("10:00");
				modelFeeType.setEndTime("02:00");
			}
		};
		modelFeeType.setFeeType("DAY_TIME");
		modelFeeType.setFeeTypeDAO(feeTypeDAOStub);
		
		modelFeeType.inquiry();
		assertEquals("10:00",modelFeeType.getStartTime());
		assertEquals("02:00",modelFeeType.getEndTime());		
	}
	
	@Test
	public void testInputDAYTIMEThenReturn0201And0959() throws Exception {
		ModelFeeType modelFeeType = new ModelFeeType();
		FeeTypeDAO feeTypeDAOStub = new FeeTypeDAO (){
			public void inquiry(ModelFeeType modelFeeType) {
				modelFeeType.setStartTime("02:01");
				modelFeeType.setEndTime("09:59");
			}
		};
		modelFeeType.setFeeType("DAY_TIME");
		modelFeeType.setFeeTypeDAO(feeTypeDAOStub);
		
		modelFeeType.inquiry();
		assertEquals("02:01",modelFeeType.getStartTime());
		assertEquals("09:59",modelFeeType.getEndTime());
	}
	
}

