package api.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import api.dao.FeeTypeDAO;

public class ModelFeeTypeTest {
	
	@Test
	public void testInputDAY_TIMEThenReturn1000And0200() throws Exception {
		ModelFeeType modelFeeType = new ModelFeeType();
		FeeTypeDAOStub feeTypeDAOStub = new FeeTypeDAOStub();
		modelFeeType.setFeeType("DAY_TIME");
		modelFeeType.setFeeTypeDAO(feeTypeDAOStub);
		
		modelFeeType.inquiry();
		assertEquals(1,feeTypeDAOStub.getCounter());
		assertEquals("10:00",modelFeeType.getStartTime());
		assertEquals("02:00",modelFeeType.getEndTime());
		assertEquals(true, false);
	}
	
}

class FeeTypeDAOStub extends FeeTypeDAO{
	int counter = 0;
	public void inquiry(ModelFeeType modelFeeType) {
		modelFeeType.setStartTime("10:00");
		modelFeeType.setEndTime("02:00");
		counter++;
	}
	
	public int getCounter() {
		return counter;
	}

}
