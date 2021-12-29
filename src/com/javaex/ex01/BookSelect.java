package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 책 데이터 가져오기

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " SELECT book_id, title, pubs, pub_date, author_id FROM book ";
			System.out.println(query);

			// 문자열 >> 쿼리
			pstmt = conn.prepareStatement(query);

			// 바인딩

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int authorBId = rs.getInt(1);
				String authorTitle = rs.getString(2);
				String authorPubs = rs.getString(3);
				String authorPubDate = rs.getString(4);
				int authorAId = rs.getInt(5);

				System.out.println(
						authorBId + ", " + authorTitle + ", " + authorPubs + ", " + authorPubDate + ", " + authorAId);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

	}

}
