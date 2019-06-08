package HW2;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class ConnectionUtils {
		public static Connection getMyConnection() throws SQLException {
			String hostName = "localhost";
			String dbName = "tutorial";
			String userName = "root";
			String password = "106110111";
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			Connection conn = DriverManager.getConnection(connectionURL, userName,password);
			return conn;
		}

	}		