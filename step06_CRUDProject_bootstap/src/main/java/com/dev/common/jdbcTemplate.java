package com.dev.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcTemplate {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static boolean isConnection(Connection conn) {
		boolean valid = true;
		try {
			if(conn == null || conn.isClosed()) {
				valid = false;
			}
		} catch (SQLException e) {
			valid = false;
			e.printStackTrace();
		}
		return valid;
	}
	
	public static void commit(Connection conn) {
		if(isConnection(conn)) {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if(isConnection(conn)) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
		close(conn,ps);
	}
	
	public static void close(Connection conn, PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch(Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		} if(conn != null) {
			try {
				conn.close();
			} catch(Exception ex) {
				System.out.println("오류 발생 : " + ex );
			}
		}
		
	}
	
}
