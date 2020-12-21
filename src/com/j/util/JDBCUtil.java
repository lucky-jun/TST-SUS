package com.j.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	private static String DriverClass = null;
	private static String URL = null;
	private static String userName = null;
	private static String passWord = null;
	private static final ThreadLocal thread_local_db = new ThreadLocal();
	
	static {
		Properties ps = new Properties();
		try {
			String path = JDBCUtil.class.getClassLoader().getResource("").toURI().getPath();
			FileInputStream is = new FileInputStream(path+"jdbc.properties");
			ps.load(is);
			DriverClass = ps.getProperty("driverClass");
			URL = ps.getProperty("url");
			userName = ps.getProperty("userName");
			passWord = ps.getProperty("passWord");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConn() {
		Connection conn = (Connection) thread_local_db.get();

		try {
			if(conn == null) {
				Class.forName(DriverClass);
				conn = DriverManager.getConnection(URL, userName, passWord);
				//把连接对象放入线程池中
				thread_local_db.set(conn);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//线程关闭
	public static void release(Connection conn,Statement st,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(st!=null) {
				st.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rs = null;
			st = null;
			conn = null;
		}
	}
}
