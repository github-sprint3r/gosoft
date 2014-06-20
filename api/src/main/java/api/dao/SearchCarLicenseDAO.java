package api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import api.model.ModelFeeType;
import api.model.Transaction;

public class SearchCarLicenseDAO {

	// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://192.168.100.222:3306/PARK_KO";

		// Database credentials
		final String USER = "park-ko";
		final String PASS = "xitgmLwmp";

		public Transaction searchCarLicense(String carlicense, int provinceid) throws SQLException {
			
			Transaction transaction = new Transaction();
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				stmt = conn.createStatement();
				String sql;
				sql = "select z.CAR_LICENSE as carlicense, "+
						"concat('วัน',z.DAYNAME_S, 'ที่  ', day_s, ' ', monthname_s, ' พ.ศ.', year_s, ' เวลา ', time_s) as startdatetxt, "+
						"concat('วัน',z.DAYNAME_e, 'ที่  ', day_e, ' ', monthname_e, ' พ.ศ.', year_e, ' เวลา ', time_e) as enddatetxt, "+
						"start_date, "+
						"end_date, "+
						"province_id "+
						"from ( "+
						" "+
						"	SELECT  "+
						"	CAR_LICENSE "+
						"	, province_id "+
						"	, (CASE dayofweek(START_DATE)  "+
						"	WHEN 1 THEN 'อาทิตย์'   "+
						"	WHEN 2 THEN 'จันทร์' "+
						"	WHEN 3 THEN 'อังคาร'   "+
						"	WHEN 4 THEN 'พุธ'  "+
						"	WHEN 5 THEN 'พฤหัสบดี'  "+
						"	WHEN 6 THEN 'ศุกร์'  "+
						"	WHEN 7 THEN 'เสาร์'    "+
						"	else 'xx' end) as DAYNAME_S , "+
						"	(CASE dayofweek(END_DATE) WHEN 1 THEN 'อาทิตย์'   "+
						"	WHEN 2 THEN 'จันทร์' "+
						"	WHEN 3 THEN 'อังคาร'   "+
						"	WHEN 4 THEN 'พุธ'  "+
						"	WHEN 5 THEN 'พฤหัสบดี'  "+
						"	WHEN 6 THEN 'ศุกร์'  "+
						"	WHEN 7 THEN 'เสาร์'    "+
						"	else '' end) as DAYNAME_E "+
						"	, date_format(start_date, '%d') as day_s "+
						"	, date_format(end_date, '%d') as day_e "+
						"	,(CASE month(START_DATE)  "+
						"	WHEN 1 THEN 'มกราคม'   "+
						"	WHEN 2 THEN 'กุมภาพันธ์' "+
						"	WHEN 3 THEN 'มีนาคม'   "+
						"	WHEN 4 THEN 'เมษายน'  "+
						"	WHEN 5 THEN 'พฤษภาคม'  "+
						"	WHEN 6 THEN 'มิถุนายน'  "+
						"	WHEN 7 THEN 'กรกฎาคม'  "+
						"	WHEN 8 THEN 'สิงหาคม'   "+
						"	WHEN 9 THEN 'กันยายน' "+
						"	WHEN 10 THEN 'ตุลาคม'   "+
						"	WHEN 11 THEN 'พฤศจิกายน'  "+
						"	WHEN 12 THEN 'ธันวคม'  "+
						"	END) as monthname_s  "+
						"	,(CASE month(END_DATE)  "+
						"	WHEN 1 THEN 'มกราคม'   "+
						"	WHEN 2 THEN 'กุมภาพันธ์' "+
						"	WHEN 3 THEN 'มีนาคม'   "+
						"	WHEN 4 THEN 'เมษายน'  "+
						"	WHEN 5 THEN 'พฤษภาคม'  "+
						"	WHEN 6 THEN 'มิถุนายน'  "+
						"	WHEN 7 THEN 'กรกฎาคม'  "+
						"	WHEN 8 THEN 'สิงหาคม'   "+
						"	WHEN 9 THEN 'กันยายน' "+
						"	WHEN 10 THEN 'ตุลาคม'   "+
						"	WHEN 11 THEN 'พฤศจิกายน'  "+
						"	WHEN 12 THEN 'ธันวคม'  "+
						"	END) as monthname_e "+
						"	, date_format(start_date, '%Y') + 543 as year_s "+
						"	, date_format(end_date, '%Y') + 543 as year_e "+
						"	, concat(date_format(start_date, '%H'),':' ,date_format(start_date, '%i'), ' น.')  as time_s "+
						"	, concat(date_format(end_date, '%H'),':' ,date_format(end_date, '%i'), ' น.')  as time_e  "+
						"	, start_date, end_date    "+
						"    , case when  date_format(timediff(end_date, start_date),'%i') > 0 then 1 else 0 end as a "+
						"    , date_format(timediff(end_date, start_date),'%h') as b	  "+
						"	FROM PARK_KO.PKO_TRANSACTION pt  "+
						" "+
						") z where province_id = '"+provinceid+"'";
						//") z where CAR_LICENSE = '1กท5555' and province_id = '"+provinceid+"'";
				
				System.out.println("sql:" + sql);
				
				rs = stmt.executeQuery(sql);
				
				System.out.println("rs:" + rs);
				
				if(rs.next()){
					
					transaction.setCarlicense(rs.getString("carlicense"));
					transaction.setProvinceid(rs.getInt("province_id"));
					transaction.setStartdate(rs.getDate("start_date"));
					transaction.setEnddate(rs.getDate("end_date"));
					transaction.setStartdatetxt(rs.getString("startdatetxt"));
					transaction.setEnddatetxt(rs.getString("enddatetxt"));
				}
				
				
			} catch (Exception ex) {
				System.out.println("ERROR:" + ex.toString());

			} finally {
				rs.close();
				stmt.close();
				conn.close();
			}

			System.out.println("transaction :" + transaction.getCarlicense() + ":" + transaction.getProvinceid());
			
			return transaction;

		}

		public ModelFeeType getModelFeeType(String feetype) throws SQLException {
			
			ModelFeeType modelfeetype = new ModelFeeType();
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				stmt = conn.createStatement();
				String sql;
				sql = "select * FROM PARK_KO.PKO_FEE_TYPE WHERE FEE_TYPE = '"+feetype+"'";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					
					modelfeetype.setEndTime(rs.getString("end_time"));
					modelfeetype.setFeeType(rs.getString("fee_type"));
					modelfeetype.setFeeTypeName(rs.getString("fee_type_name"));
				}
				
				
			} catch (Exception ex) {
				System.out.println("ERROR:" + ex.toString());

			} finally {
				rs.close();
				stmt.close();
				conn.close();
			}

			return modelfeetype;

		}
	
}
