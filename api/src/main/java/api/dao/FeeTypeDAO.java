package api.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import api.model.ModelFeeType;
import api.util.DatabaseUtils;

public class FeeTypeDAO {

	public void inquiry(ModelFeeType modelFeeType) throws Exception {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			String feeType = modelFeeType.getFeeType();
			connection = DatabaseUtils.getConnection();
			statement = connection.createStatement();
			String sql = "SELECT `ID`, `FEE_TYPE`, `FEE_TYPE_NAME`, `START_TIME`, `END_TIME` FROM `PARK_KO`.`PKO_FEE_TYPE` WHERE FEE_TYPE = '"
					+ feeType + "';";
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				modelFeeType.setId(resultSet.getString("ID"));
				modelFeeType.setFeeType(resultSet.getString("FEE_TYPE"));
				modelFeeType.setFeeTypeName(resultSet
						.getString("FEE_TYPE_NAME"));
				modelFeeType.setStartTime(resultSet.getString("START_TIME"));
				modelFeeType.setEndTime(resultSet.getString("END_TIME"));
			}
		} catch (Exception exception) {
			throw exception;
		} finally {
			DatabaseUtils.releaseResources(connection, statement, resultSet);
		}
	}
}
