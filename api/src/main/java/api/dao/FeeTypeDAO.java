package api.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import api.model.ModelFeeType;
import api.util.DatabaseUtils;

public class FeeTypeDAO {

	public ModelFeeType inquiry(ModelFeeType modelFeeTypeInput) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ModelFeeType modelFeeTypeOutput = new ModelFeeType();
		try {
			String feeType = modelFeeTypeInput.getFeeType();

			 connection = DatabaseUtils.getConnection();
			statement = connection.createStatement();
			String sql = "SELECT `ID`, `FEE_TYPE`, `FEE_TYPE_NAME`, `START_TIME`, `END_TIME` FROM `PARK_KO`.`PKO_FEE_TYPE` WHERE FEE_TYPE = '"
					+ feeType + "';";
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				modelFeeTypeOutput.setId(resultSet.getString("ID"));
				modelFeeTypeOutput.setFeeType(resultSet.getString("FEE_TYPE"));
				modelFeeTypeOutput.setFeeTypeName(resultSet
						.getString("FEE_TYPE_NAME"));
				modelFeeTypeOutput.setStartTime(resultSet
						.getString("START_TIME"));
				modelFeeTypeOutput.setEndTime(resultSet.getString("END_TIME"));
			}
		} catch (Exception ex) {
			System.out.println("ERROR:" + ex.toString());

		} finally {
			 try {
				DatabaseUtils.releaseResources(connection, statement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return modelFeeTypeOutput;

	}

}
