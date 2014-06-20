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
		final String DB_URL = "jdbc:mysql://192.168.100.222:3306/PARK_KO?useUnicode=true&characterEncoding=UTF-8";

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

				 String sql = " select  " +
						 "     y.carlicensetxt, " +
						 "     y.province_id, " +
						 "     y.startdatetxt, " +
						 "     y.enddatetxt, " +
						 "     y.totalofhourtxt, " +
						 "     getTotalCostDayTime(y.day_time_hour) + getTotalCostNightTime(y.night_time_hour) as netpricetxt,  " +
						 " 	y.day_time_hour,  " +
						 " 	y.night_time_hour " +
						 " from " +
						 "     (select  " +
						 "         z.CAR_LICENSE as carlicensetxt,z.province_id, " +
						 "             concat('วัน', z.DAYNAME_S, 'ที่  ', day_s, ' ', monthname_s, ' พ.ศ.', year_s, ' เวลา ', time_s) as startdatetxt, " +
						 "             concat('วัน', z.DAYNAME_e, 'ที่  ', day_e, ' ', monthname_e, ' พ.ศ.', year_e, ' เวลา ', time_e) as enddatetxt, " +
						 "             z.time_full + z.time_fraction as totalofhourtxt, " +
						 "             (case " +
						 "                 when (z.yyyymmdd_s = z.yyyymmdd_e) then getTimeRoundUp(z.start_time, z.end_time) " +
						 "                 else getTimeRoundUp(z.start_time, '24:00') + date_format(timediff(z.end_time_day_time, '24:00'), '%h') " +
						 "             end) as day_time_hour, " +
						 "             (case " +
						 "                 when (z.yyyymmdd_s = z.yyyymmdd_e) then 0 " +
						 "                 else (case " +
						 "                     when z.end_time = z.start_time_night_time then 1 " +
						 "                     when z.end_time < z.end_time_night_time then getTimeRoundUp(z.start_time_night_time, z.end_time) " +
						 "                     else getTimeRoundUp(z.start_time_night_time, z.end_time_night_time) " +
						 "                 end) " +
						 "             end) as night_time_hour " +
						 "     from " +
						 "         (SELECT  " +
						 "         CAR_LICENSE,province_id, " +
						 "             (CASE dayofweek(START_DATE) " +
						 "                 WHEN 1 THEN 'อาทิตย์' " +
						 "                 WHEN 2 THEN 'จันทร์' " +
						 "                 WHEN 3 THEN 'อังคาร' " +
						 "                 WHEN 4 THEN 'พุธ' " +
						 "                 WHEN 5 THEN 'พฤหัสบดี' " +
						 "                 WHEN 6 THEN 'ศุกร์' " +
						 "                 WHEN 7 THEN 'เสาร์' " +
						 "                 else 'xx' " +
						 "             end) as DAYNAME_S, " +
						 "             (CASE dayofweek(END_DATE) " +
						 "                 WHEN 1 THEN 'อาทิตย์' " +
						 "                 WHEN 2 THEN 'จันทร์' " +
						 "                 WHEN 3 THEN 'อังคาร' " +
						 "                 WHEN 4 THEN 'พุธ' " +
						 "                 WHEN 5 THEN 'พฤหัสบดี' " +
						 "                 WHEN 6 THEN 'ศุกร์' " +
						 "                 WHEN 7 THEN 'เสาร์' " +
						 "                 else '' " +
						 "             end) as DAYNAME_E, " +
						 "             date_format(start_date, '%d') as day_s, " +
						 "             date_format(end_date, '%d') as day_e, " +
						 "             (CASE month(START_DATE) " +
						 "                 WHEN 1 THEN 'มกราคม' " +
						 "                 WHEN 2 THEN 'กุมภาพันธ์' " +
						 "                 WHEN 3 THEN 'มีนาคม' " +
						 "                 WHEN 4 THEN 'เมษายน' " +
						 "                 WHEN 5 THEN 'พฤษภาคม' " +
						 "                 WHEN 6 THEN 'มิถุนายน' " +
						 "                 WHEN 7 THEN 'กรกฎาคม' " +
						 "                 WHEN 8 THEN 'สิงหาคม' " +
						 "                 WHEN 9 THEN 'กันยายน' " +
						 "                 WHEN 10 THEN 'ตุลาคม' " +
						 "                 WHEN 11 THEN 'พฤศจิกายน' " +
						 "                 WHEN 12 THEN 'ธันวคม' " +
						 "             END) as monthname_s, " +
						 "             (CASE month(END_DATE) " +
						 "                 WHEN 1 THEN 'มกราคม' " +
						 "                 WHEN 2 THEN 'กุมภาพันธ์' " +
						 "                 WHEN 3 THEN 'มีนาคม' " +
						 "                 WHEN 4 THEN 'เมษายน' " +
						 "                 WHEN 5 THEN 'พฤษภาคม' " +
						 "                 WHEN 6 THEN 'มิถุนายน' " +
						 "                 WHEN 7 THEN 'กรกฎาคม' " +
						 "                 WHEN 8 THEN 'สิงหาคม' " +
						 "                 WHEN 9 THEN 'กันยายน' " +
						 "                 WHEN 10 THEN 'ตุลาคม' " +
						 "                 WHEN 11 THEN 'พฤศจิกายน' " +
						 "                 WHEN 12 THEN 'ธันวคม' " +
						 "             END) as monthname_e, " +
						 "             date_format(start_date, '%Y') + 543 as year_s, " +
						 "             date_format(end_date, '%Y') + 543 as year_e, " +
						 "             concat(date_format(start_date, '%H'), ':', date_format(start_date, '%i'), ' น.') as time_s, " +
						 "             concat(date_format(end_date, '%H'), ':', date_format(end_date, '%i'), ' น.') as time_e, " +
						 "             date_format(timediff(end_date, start_date), '%h') as time_full, " +
						 "             case " +
						 "                 when date_format(timediff(end_date, start_date), '%i') > 0 then 1 " +
						 "                 else 0 " +
						 "             end as time_fraction,  " +
						 "             date_format(start_date, '%Y%m%d') as yyyymmdd_s, " +
						 "             concat(date_format(start_date, '%H'), ':', date_format(start_date, '%i')) as start_time, " +
						 "             case " +
						 "                 when end_date is null then sysdate() " +
						 "                 else end_date " +
						 "             end as end_date, " +
						 "             case " +
						 "                 when end_date is null then concat(date_format(sysdate(), '%H'), ':', date_format(sysdate(), '%i')) " +
						 "                 else concat(date_format(end_date, '%H'), ':', date_format(end_date, '%i')) " +
						 "             end as end_time, " +
						 "             case " +
						 "                 when end_date is null then date_format(sysdate(), '%Y%m%d') " +
						 "                 else date_format(end_date, '%Y%m%d') " +
						 "             end as yyyymmdd_e,      " +
						 "             (select  " +
						 "                     START_TIME " +
						 "                 from " +
						 "                     pko_fee_type " +
						 "                 where " +
						 "                     fee_type = 'DAY_TIME') as start_time_day_time, " +
						 "             (select  " +
						 "                     END_TIME " +
						 "                 from " +
						 "                     pko_fee_type " +
						 "                 where " +
						 "                     fee_type = 'DAY_TIME') as end_time_day_time, " +
						 "             (select  " +
						 "                     START_TIME " +
						 "                 from " +
						 "                     pko_fee_type " +
						 "                 where " +
						 "                     fee_type = 'NIGHT_TIME') as start_time_night_time, " +
						 "             (select  " +
						 "                     END_TIME " +
						 "                 from " +
						 "                     pko_fee_type " +
						 "                 where " +
						 "                     fee_type = 'NIGHT_TIME') as end_time_night_time " +
						 "     FROM " +
						 "         PARK_KO.PKO_TRANSACTION pt) z) y " +
						 " where carlicensetxt = '"+carlicense+"' and province_id = '"+provinceid+"' ";

				 System.out.println("sql:" + sql);
				
				rs = stmt.executeQuery(sql);
				
				System.out.println("rs:" + rs);
				
				if(rs.next()){
					
					transaction.setCarlicense(rs.getString("carlicensetxt"));
					transaction.setProvinceid(rs.getInt("province_id"));
					transaction.setStartdatetxt(rs.getString("startdatetxt"));
					transaction.setEnddatetxt(rs.getString("enddatetxt"));					
					transaction.setDaytimehour(rs.getInt("day_time_hour"));
					transaction.setNighttimehour(rs.getInt("night_time_hour"));
					transaction.setTotalhourtxt(rs.getString("totalofhourtxt"));
					transaction.setNetpricetxt(rs.getInt("netpricetxt"));
	
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
