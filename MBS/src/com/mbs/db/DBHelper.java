package com.mbs.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * 获取数据库连接 配置数据源 
 * @author 何虎
 *
 */
public class DBHelper {
	
	private static Context context = null;
	private static DataSource ds = null;
	private static final ThreadLocal<Connection> tl = new ThreadLocal<>();
	
	static{
		try {
			context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = tl.get();
		if(conn==null){
			try {
				conn = ds.getConnection();
				tl.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void release(){
		Connection conn = tl.get();
		try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
				tl.set(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
