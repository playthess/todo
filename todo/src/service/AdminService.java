package service;

import java.sql.Connection;
import java.sql.SQLException;


import commons.DBUtil;
import dao.AdminDao;
import vo.Admin;
import vo.Notice;

public class AdminService {
	private AdminDao adminDao;
	
	// 어드민 로그인 
	public Admin adminLoginService(Admin admin) {
		System.out.println("AdminService adminLoginService "+admin.toString());
		
		Admin loginAdmin = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			adminDao = new AdminDao();
			loginAdmin = adminDao.adminLoginDao(conn, admin);
		}catch(Exception e) {
			System.out.println("adminLoginService_conn:Exception");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println("adminLoginService_SQLException");
				e.printStackTrace();
			}
		}
		return loginAdmin;
	}
	// 게시판(공지사항) 글 입력
	public void adminAddNoticeService(Notice notice) {
		System.out.println("AdminService adminAddNoticeService "+notice.toString());
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			adminDao = new AdminDao();
			adminDao.AddNoticeDao(conn, notice);
		}catch(Exception e) {
			System.out.println("AddNoticeService_conn:Exception");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println("AddNoticeService_SQLException");
				e.printStackTrace();
			}
		}
		return;
	}
	// 게시판(공지사항) 수정
	public void adminUpdateNoticeService(Notice notice) {
		System.out.println("adminUpdateNoticeService "+notice.toString());
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			adminDao = new AdminDao();
			adminDao.UpdateNoticeDao(conn, notice);
		}catch(Exception e) {
			System.out.println("UpdateNoticeService_conn:Exception");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println("UpdateNoticeService_SQLException");
				e.printStackTrace();
			}
		}
		return;
	}
	// 게시판(공지사항) 삭제
	public void adminDeleteNoticeService(int noticeNo) {
		System.out.println("DeleteNoticeService noticeNo:"+ noticeNo);
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			adminDao = new AdminDao();
			adminDao.DeleteNoticeDao(conn, noticeNo);
		}catch(Exception e) {
			System.out.println("DeleteNoticeService_conn:Exception");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println("DeleteNoticeService_SQLException");
				e.printStackTrace();
			}
		}
		return;
	}
}
