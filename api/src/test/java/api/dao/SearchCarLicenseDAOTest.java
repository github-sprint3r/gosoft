package api.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SearchCarLicenseDAOTest {

	SearchCarLicenseDAO searchCarLicenseDAO = new SearchCarLicenseDAO();

	@Test
	public void test_carlicensekt9999_province2_getNetpricetxt0()
			throws Exception {

		String carlicense = "กท9999";
		int provinceid = 2;

		assertEquals(0,
				searchCarLicenseDAO.searchCarLicense(carlicense, provinceid)
						.getNetpricetxt());
	}

	@Test
	public void test_carlicensekt1234_province2_getNetpricetxt20()
			throws Exception {

		String carlicense = "กท1234";
		int provinceid = 2;
		assertEquals(
				40,
				searchCarLicenseDAO.searchCarLicense(carlicense,
						provinceid).getNetpricetxt());
	}

	@Test
	public void test_carlicensekt1245_province2_getNetpricetxt90()
			throws Exception {

		String carlicense = "กท1245";
		int provinceid = 2;
		assertEquals(
				90,
				searchCarLicenseDAO.searchCarLicense(carlicense,
						provinceid).getNetpricetxt());
	}

	@Test
	public void test_carlicensekt1246_province2_getNetpricetxt50()
			throws Exception {

		String carlicense = "กท1246";
		int provinceid = 2;
		assertEquals(
				90,
				searchCarLicenseDAO.searchCarLicense(carlicense,
						provinceid).getNetpricetxt());
	}

	@Test
	public void test_carlicense1sk570_province14_getNetpricetxt690()
			throws Exception {

		String carlicense = "1สก570";
		int provinceid = 14;
		assertEquals(
				690,
				searchCarLicenseDAO.searchCarLicense(carlicense,
						provinceid).getNetpricetxt());
	}

	@Test
	public void test_carlicense1kt5555_province2_getNetpricetxt650()
			throws Exception {

		String carlicense = "1กท5555";
		int provinceid = 2;
		assertEquals(
				690,
				searchCarLicenseDAO.searchCarLicense(carlicense,
						provinceid).getNetpricetxt());
	}

}
