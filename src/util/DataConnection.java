package util;

import java.sql.*;

public class DataConnection {
	public static Connection connect() throws SQLException{
		//Load Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//Create Connection
		String url="jdbc:mysql://localhost/celebration_hut";
		String user="root";
		String password="";
		Connection con=DriverManager.getConnection(url, user, password);
		return con;
	}
}