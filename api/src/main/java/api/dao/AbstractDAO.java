package api.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {

	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://192.168.100.222/PARK_KO";

	final String USER = "park-ko";
	final String PASS = "xitgmLwmp";
	
	public Connection getConnection() throws Exception{
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
	
}
