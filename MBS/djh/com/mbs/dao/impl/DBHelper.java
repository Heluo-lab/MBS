package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	private static final String DRIVER="driver";
	private static final String URL="url";
	private static final String USERNAME="username";
	private static final String PASSWORD="password";
	
	//准备一个属性配置文件的对象
	private static final Properties CONFIG=new Properties();
	//用静态块加载配置文件和驱动
	static{
		try {
			//加载配置文件(文件在项目下)
			//CONFIG.load(new FileInputStream("db.properties"));
			//加载配置文件(文件在src目录下)
			CONFIG.load(DBHelper.class.getClassLoader().getResourceAsStream("db.properties"));
			//加载驱动
			Class.forName(CONFIG.getProperty(DRIVER));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获得连接
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(CONFIG.getProperty(URL),CONFIG.getProperty(USERNAME),CONFIG.getProperty(PASSWORD));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//关闭连接
	public static void closeConnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
