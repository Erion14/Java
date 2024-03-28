package jdbc;

import java.sql.SQLException;
import java.sql.Savepoint;

public class JDBCTransacitonExample {


	public static void main(String[] args) {
		String updateQuery = "UPDATE user SET money = ? WHERE iduser = ?";
		String selectQuery = "SELECT * FROM user WHERE iduser = ?";

		double moneyToTransfer = 50;
		int userFromId = 3;
		int userToId = 4;

		try (var conn = DBUtils.getConnection();
				var psSelect = conn.prepareStatement(selectQuery);
				var psUpdate = conn.prepareStatement(updateQuery);) {

			Savepoint savepoint = null;
			try {
				conn.setAutoCommit(false);

				psSelect.setInt(1, userFromId);
				try (var rs = psSelect.executeQuery()) {
					if (rs.next() == true) {
						double moneyAmount = rs.getDouble("money");
						if (moneyToTransfer > moneyAmount) {
							System.out.println("Not enough money for transfer");
							return;
						} else {
							moneyAmount -= moneyToTransfer;
							psUpdate.setDouble(1, moneyAmount);
							psUpdate.setInt(2, userFromId);
							psUpdate.executeUpdate();
						}
					}
				}

//				savepoint = conn.setSavepoint();
				
				psSelect.setInt(1, userToId);
				try (var rs = psSelect.executeQuery()) {
					if (rs.next() == true) {
						double moneyAmount = rs.getDouble("money");
						moneyAmount += moneyToTransfer;
						psUpdate.setDouble(1, moneyAmount);
						psUpdate.setInt(2, userToId);
						psUpdate.executeUpdate();
					}
				}

				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				conn.rollback();
//				conn.rollback(savepoint);
			}
			System.out.println("Money transferred");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
