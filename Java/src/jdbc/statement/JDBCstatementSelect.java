package jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.DBUtils;

public class JDBCstatementSelect {

	
	public static void main(String[] args) throws SQLException {
		String query = "SELECT * FROM user";
		
		try (var conn = DBUtils.getConnection();
				Statement statement = conn.createStatement()) {
			try (ResultSet rs = statement.executeQuery(query)) {
				while (rs.next()) {
					System.out.println("=================");
					System.out.println("ID:\t\t" + rs.getInt("iduser"));
					System.out.println("First Name:\t" + rs.getString("username"));
					System.out.println("Last Name:\t" + rs.getString("userlastname"));
					System.out.println("Email:\t\t" + rs.getString("email"));
				}
			};
			
		}
	}

}
