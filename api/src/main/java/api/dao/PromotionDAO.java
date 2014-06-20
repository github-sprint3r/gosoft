package api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import api.model.ModelPromotion;
import api.util.DatabaseUtils;

public class PromotionDAO {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public void initialResourceConnection(String sql) throws Exception {
		if (connection == null) {
			connection = DatabaseUtils.getConnection();
			statement = connection.createStatement();
		}

		resultSet = statement.executeQuery(sql);

	}

	public void releaseResourceConnection() throws Exception {
		DatabaseUtils.releaseResources(connection, statement, resultSet);
	}

	public void inquiry(ModelPromotion modelPromotion) throws Exception {
		String feeType = modelPromotion.getFeeType();

		String query = "SELECT ID, FEE_TYPE, PROMOTION_NAME, DISCOUNT_HOURS "
				+ "FROM PKO_PROMOTION " + "WHERE FEE_TYPE = '" + feeType + "' "
				+ "ORDER BY ID";

		initialResourceConnection(query);

		try {
			if (resultSet.next()) {
				modelPromotion.setId(resultSet.getString("ID"));
				modelPromotion.setFeeType(resultSet.getString("FEE_TYPE"));
				modelPromotion.setPromotionName(resultSet.getString("PROMOTION_NAME"));
				modelPromotion.setDiscountHours(resultSet.getString("DISCOUNT_HOURS"));
			}
		} catch (Exception exception) {
			throw exception;
		} finally {
			releaseResourceConnection();
		}
	}

	public void save(ModelPromotion modelPromotion) throws Exception {
		String feeType = modelPromotion.getFeeType();
		String query = "DELETE PKO_PROMOTION WHERE FEE_TYPE = '" + feeType+ "';";
		initialResourceConnection(query);

		try {
			String queryInsertIntoPromotion = "INSERT INTO PKO_PROMOTION (ID,FEE_TYPE,PROMOTION_NAME,DISCOUNT_HOURS) VALUES (?, ?, ?, ?)";
			PreparedStatement prepareStatement = connection.prepareStatement(queryInsertIntoPromotion);

			String promotionName = modelPromotion.getPromotionName();

			if (promotionName != null && !promotionName.equals("")) {
				prepareStatement.setString(1, modelPromotion.getId());
				prepareStatement.setString(2, modelPromotion.getFeeType());
				prepareStatement.setString(3, modelPromotion.getPromotionName());
				prepareStatement.setString(4, modelPromotion.getDiscountHours());
				prepareStatement.executeUpdate();
			}

		} catch (Exception exception) {
			throw exception;
		} finally {
			releaseResourceConnection();
		}
	}

}
