package api.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
	public static Connection getConnection() throws Exception {
		String DATABASE_URL = "jdbc:mysql://192.168.100.222:3306/PARK_KO?useUnicode=true&characterEncoding=UTF-8";

		String DATABASE_USERNAME = "park-ko";
		String DATABASE_PASSWORD = "xitgmLwmp";
		
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
	}
	
	public static void releaseResources(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		connection.close();
		statement.close();
		resultSet.close();
	}
}
