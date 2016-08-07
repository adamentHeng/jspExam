package com.maheng.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;



public class DBUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
	
	static{
		try {
			InputStream inputStream = DBUtils.class.getResourceAsStream("/jdbc.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	/*构造方法私有化*/
	private DBUtils(){
	}
	
	/*打开一个新的连接
	 * */
	public static Connection openConn(){
		Connection conn = conns.get();
		try {
			if( conn == null || conn.isClosed() ) {
				conn = DriverManager.getConnection(url, username, password);
				conns.set(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/*关闭一个连接
	 * */
	public static void closeConn(){
		Connection conn = conns.get();
		try {
			if( conn != null && !conn.isClosed() ){
				conn.close();
				conns.remove();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
