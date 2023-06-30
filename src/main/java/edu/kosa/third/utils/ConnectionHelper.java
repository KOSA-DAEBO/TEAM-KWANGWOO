package edu.kosa.third.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionHelper {
	public static Connection getConnection(String dsn) {
		//Oracle , Mysql 두개를 사용한다는 전제하에
		if(dsn.toLowerCase().equals("oracle")) {
			try {
					Context context = new InitialContext();
					DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
					Connection conn = ds.getConnection();
					return conn;
			} catch (Exception e) {
				System.out.println("connection : " + e.getMessage());
				return null;
			}
			
		}else if(dsn.toLowerCase().equals("mysql")) {
			try {
				  Class.forName("com.mysql.cj.jdbc.Driver");
				  Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.3:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true","kosta","1004");
				  return conn;
			} catch (Exception e) {
				return null;
			}
		}else {
			return null;
		}
	}
	
	
	 public static void close(Connection conn) {

			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

		
		public static void close(Statement stmt) {
			if(stmt != null) {
				try {
					stmt.close();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

		public static void close(ResultSet rs) {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

		public static void close(PreparedStatement pstmt) {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	
}
