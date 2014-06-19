package api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import api.model.Province;

public class CarLicenseDAO {

	// JDBC driver name and database URL
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://192.168.100.222/PARK_KO";

	// Database credentials
	final String USER = "park-ko";
	final String PASS = "xitgmlwmp";

	public List<Province> getProvince() throws SQLException {
		List<Province> provinceList = new ArrayList<Province>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql;
			sql = "select * from PKO_PROVINCE ORDER BY CONVERT(province_name USING TIS620)";
			rs = stmt.executeQuery(sql);
			System.out.println("result size " + rs.getFetchSize());

		} catch (Exception ex) {
			System.out.println("ERROR:" + ex.toString());

		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}

		return provinceList;

	}

}
