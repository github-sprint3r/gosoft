package api.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import api.dao.FeeDAO;

public class ModelFeeTest {

	@Test
	public void testInputDAYTIMEThenReturnID1_3() throws Exception {
		ModelFee modelFee = new ModelFee();
		FeeDAO feeDAOStub = new FeeDAO() {
			public void inquiry(ModelFee modelFee) {
				List<String> id = new ArrayList<String>();
				id.add("1");
				id.add("2");
				id.add("3");
				modelFee.setId(id);
			}
		};
		modelFee.setFeeType("DAY_TIME");
		modelFee.setFeeDAO(feeDAOStub);

		modelFee.inquiry();
		List<String> id = new ArrayList<String>();
		id.add("1");
		id.add("2");
		id.add("3");
		assertEquals(id, modelFee.getId());
	}
}