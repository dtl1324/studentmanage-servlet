package studentmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnectDB {
	private static final String url = "jdbc:mysql://localhost:3306/studentmanager?useUnicode=yes&characterEncoding=UTF-8";
	private static final String user = "root";
	private static final String password = "1234";

	public static Connection createConnection() {
	Connection conn=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url, user, password);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return conn;

	}
}
