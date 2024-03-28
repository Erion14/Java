package jdbc.statement;

import java.sql.SQLException;
import java.sql.Statement;

import jdbc.DBUtils;

public class JDBCstatementInsert {

	
	public static void main(String[] args) throws SQLException {
		String query = "INSERT INTO user (username, userlastname, email, fk_user_role, money) VALUES ('Joni', 'Berisha', 'j.berish@email.com', 4, 200)";
		try (var conn = DBUtils.getConnection();
				Statement statement = conn.createStatement()) {
			int rows = statement.executeUpdate(query);
			System.out.println(rows);
			
		}
	}
}
