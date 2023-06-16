package com.tech.w01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
	private static MemberDAO instance;
	Connection conn;
	PreparedStatement pstmt;
	
	public static MemberDAO getInstance() {
		if(instance==null)
			instance=new MemberDAO();
		
		return instance;
	}
	
	public void joinMember(MemberBean bean) {
		conn=DBConnection.getConnection();
		
		String sql="insert into test values(?, ?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}