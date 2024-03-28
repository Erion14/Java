package jdbc.statement;

import java.sql.SQLException;
import java.sql.Statement;

import jdbc.DBUtils;

public class JDBCstatementUpdate {
	
	public static void main(String[] args) throws SQLException {
		String query = "UPDATE user SET money = 120.00 WHERE iduser = 2";
		try (var conn = DBUtils.getConnection();
				Statement statement = conn.createStatement()) {
			int rows = statement.executeUpdate(query);
			System.out.println(rows);
			
		}
	}

}
