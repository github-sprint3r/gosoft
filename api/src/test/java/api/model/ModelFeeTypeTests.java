package api.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import api.DAO.FeeTypeDAO;

public class ModelFeeTypeTests {
	
	@Test
	public void testInputDAY_TIMEThenReturn1000And0200() throws Exception {
		ModelFeeType modelFeeType = new ModelFeeType();
		modelFeeType.setFeeType("DAY_TIME");
		modelFeeType.setFeeTypeDAO(new FeeTypeDAOStub());
		
		modelFeeType.inquiry();
		assertEquals("10:00",modelFeeType.getStartTime());
		
	}
	
}

class FeeTypeDAOStub extends FeeTypeDAO{
	int counter = 0;
	public void inquiry(ModelFeeType modelFeeType) {
		counter++;
	}

}
