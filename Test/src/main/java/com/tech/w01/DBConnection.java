package com.tech.w01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "123456";
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 적재 성공!");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 없음!");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패!");
		}

		return conn;
	}
}