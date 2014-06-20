package api.model;

import static org.junit.Assert.*;

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
	
	@Test
	public void checkTrueData() {
		ModelFee modelFee = new ModelFee();
		List<String> hourStarts = new ArrayList<String>();
		hourStarts.add("1");
		hourStarts.add("2");
		hourStarts.add("4");
		List<String> hourEnds = new ArrayList<String>();
		hourEnds.add("1");
		hourEnds.add("3");
		hourEnds.add("99");
		modelFee.setHourStart(hourStarts);
		modelFee.setHourEnd(hourEnds);
		assertTrue(modelFee.checkData());
	}
	
	@Test
	public void checkDataNewStartEqualEnd() {
		ModelFee modelFee = new ModelFee();
		List<String> hourStarts = new ArrayList<String>();
		hourStarts.add("1");
		hourStarts.add("2");
		hourStarts.add("");
		List<String> hourEnds = new ArrayList<String>();
		hourEnds.add("2");
		hourEnds.add("3");
		hourEnds.add("");
		modelFee.setHourStart(hourStarts);
		modelFee.setHourEnd(hourEnds);
		assertFalse(modelFee.checkData());
	}
	
	@Test
	public void checkDataStartLessEnd() {
		ModelFee modelFee = new ModelFee();
		List<String> hourStarts = new ArrayList<String>();
		hourStarts.add("1");
		hourStarts.add("4");
		hourStarts.add("");
		List<String> hourEnds = new ArrayList<String>();
		hourEnds.add("5");
		hourEnds.add("99");
		hourEnds.add("");
		modelFee.setHourStart(hourStarts);
		modelFee.setHourEnd(hourEnds);
		assertFalse(modelFee.checkData());
	}
	
	@Test
	public void checkDataIsReuseable() {
		ModelFee modelFee = new ModelFee();
		List<String> hourStarts = new ArrayList<String>();
		hourStarts.add("1");
		hourStarts.add("3");
		hourStarts.add("8");
		List<String> hourEnds = new ArrayList<String>();
		hourEnds.add("1");
		hourEnds.add("3");
		hourEnds.add("8");
		modelFee.setHourStart(hourStarts);
		modelFee.setHourEnd(hourEnds);
		assertTrue(modelFee.checkData());
	}
	
	@Test
	public void checkDataNotOrder() {
		ModelFee modelFee = new ModelFee();
		List<String> hourStarts = new ArrayList<String>();
		hourStarts.add("4");
		hourStarts.add("3");
		hourStarts.add("1");
		List<String> hourEnds = new ArrayList<String>();
		hourEnds.add("99");
		hourEnds.add("3");
		hourEnds.add("1");
		modelFee.setHourStart(hourStarts);
		modelFee.setHourEnd(hourEnds);
		assertTrue(modelFee.checkData());
	}
	
	@Test
	public void checkDataDuplicateEnd() {
		ModelFee modelFee = new ModelFee();
		List<String> hourStarts = new ArrayList<String>();
		hourStarts.add("1");
		hourStarts.add("5");
		hourStarts.add("10");
		List<String> hourEnds = new ArrayList<String>();
		hourEnds.add("1");
		hourEnds.add("1");
		hourEnds.add("99");
		modelFee.setHourStart(hourStarts);
		modelFee.setHourEnd(hourEnds);
		assertFalse(modelFee.checkData());
	}
}