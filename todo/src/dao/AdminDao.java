package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Admin;
import vo.Notice;

public class AdminDao {
	// 어드민 로그인 
	public Admin adminLoginDao(Connection conn, Admin paramAdmin) throws SQLException {
		Admin loginAdmin = null;
		String sql = AdminQuery.ADMIN_LOGIN;// sql문 AdminQuery로 분리
		PreparedStatement stmt = conn.prepareStatement(sql);
		System.out.println("Admin LoginDao:"+paramAdmin.toString());
		
		stmt.setString(1, paramAdmin.getAdminId());
		stmt.setString(2, paramAdmin.getAdminPw());
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			loginAdmin = new Admin();
			loginAdmin.setAdminId(rs.getString("adminId"));
		}
		rs.close();
		stmt.close();
		return loginAdmin;
	}
	// 게시판(공지사항) 글 입력
	public void AddNoticeDao(Connection conn, Notice notice) throws SQLException {
		String sql = AdminQuery.INSERT_NOTICE;// sql문 AdminQuery로 분리
		PreparedStatement stmt = conn.prepareStatement(sql);
		System.out.println("AddNoticeDao:"+notice.toString());
		
		stmt.setInt(1, notice.getNoticeNo());
		stmt.setString(2, notice.getNoticeTitle());
		stmt.setString(3, notice.getNoticeContent());
		stmt.executeQuery();	
		stmt.close();
		
		return;
	}
	// 게시판(공지사항) 수정
	public void UpdateNoticeDao(Connection conn, Notice notice) throws SQLException {
		String sql = AdminQuery.UPDATE_NOTICE;// sql문 AdminQuery로 분리
		PreparedStatement stmt = conn.prepareStatement(sql);
		System.out.println("UpdateNoticeDao:"+notice.toString());
		
		stmt.setString(1, notice.getNoticeTitle());
		stmt.setString(2, notice.getNoticeContent());
		stmt.setInt(3, notice.getNoticeNo());
		stmt.executeQuery();
		stmt.close();
		
		return;
	}
	// 게시판(공지사항) 삭제
	public void DeleteNoticeDao(Connection conn, int noticeNo) throws SQLException {
		String sql = AdminQuery.DELETE_NOTICE;// sql문 AdminQuery로 분리
		PreparedStatement stmt = conn.prepareStatement(sql);
		System.out.println("DeleteNoticeDao noticeNo:"+ noticeNo);
		
		stmt.setInt(1, noticeNo);
		stmt.executeQuery();
		stmt.close();
		
		return;
	}
}
