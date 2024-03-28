package jdbc.statement;

import java.sql.SQLException;
import java.sql.Statement;

import jdbc.DBUtils;


public class JDCBstatementDelete {
	
	public static void main(String[] args) throws SQLException {
		String query = "DELETE FROM user WHERE id = 20";
		
		try (var conn = DBUtils.getConnection();
				Statement statement = conn.createStatement()) {
			
			int rows = statement.executeUpdate(query);
			System.out.println(rows);
			
		}
	}
	
}