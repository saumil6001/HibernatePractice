package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDao {

	private static Connection connection = null;
	private final static String database_url = "jdbc:mysql://localhost/";
	private final static String database_name = "assignment1";
	private final static String database_userName = "saumil";
	private final static String databse_passward = "123456789";
	private final static String database_driverName = "com.mysql.jdbc.Driver";

	public static void main(String[] args) {
		if (connect()) {
			System.out.println("Connected");
		}
	}

	public static boolean connect() {

		try { // Class.forName(database_driverName); connection =
			DriverManager.getConnection(database_url + database_name, database_userName, databse_passward);
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return false;
	}

	public static boolean connectionClose() {

		if (connection != null) {
			try {
				connection.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;

			}
		}
		return true;

	}

}
