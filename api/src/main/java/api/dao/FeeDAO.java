package api.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import api.model.ModelFee;
import api.util.DatabaseUtils;

public class FeeDAO {

	public void inquiry(ModelFee modelFee) throws Exception {
		String feeType = modelFee.getFeeType();
		String query = "SELECT ID, FEE_NAME, HOUR_START, HOUR_END, FEE_PER_HOUR "
				+ "FROM PKO_FEE "
				+ "WHERE FEE_TYPE = '"+feeType+"' "
				+ "ORDER BY ID";
		
		Connection connection = DatabaseUtils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		List<String> ids = new ArrayList<String>();
		List<String> feeNames = new ArrayList<String>();
		List<String> hourStarts = new ArrayList<String>();
		List<String> hourEnds = new ArrayList<String>();
		List<String> feePerHours = new ArrayList<String>();
		
		for (int dataRow = 0; dataRow < 3; dataRow++) {
			if(resultSet.next()) {
				ids.add(resultSet.getString("ID"));
				feeNames.add(resultSet.getString("FEE_NAME"));
				hourStarts.add(resultSet.getString("HOUR_START"));
				hourEnds.add(resultSet.getString("HOUR_END"));
				feePerHours.add(resultSet.getString("FEE_PER_HOUR"));
			} else {
				ids.add("");
				feeNames.add("");
				hourStarts.add("");
				hourEnds.add("");
				feePerHours.add("");
			}
		}
		modelFee.setId(ids);
		modelFee.setFeeName(feeNames);
		modelFee.setHourStart(hourStarts);
		modelFee.setHourEnd(hourEnds);
		modelFee.setFeePerHour(feePerHours);
		DatabaseUtils.releaseResources(connection, statement, resultSet);
	}

	public void save(ModelFee modelFee) {
	}
}
