package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.DBUtil;
import dao.NoticeDao;
import vo.Notice;

public class NoticeService {
	private NoticeDao notcieDao;
	
	// 공지사항 출력
	public List<Notice> getNoticeOne(int noticeNo) {
		System.out.println("NoticeService noticeNo : "+ noticeNo);
		List<Notice> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			notcieDao = new NoticeDao();
			list = notcieDao.selectNoticeOne(conn, noticeNo);
		} catch (SQLException e) {
			System.out.println("getNoticeOne: Exception");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("getNoticeOne: SQLException");
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 로그인 공지사항 3개 출력
	public List<Notice> getNoticeList3() {
		List<Notice> list = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			notcieDao = new NoticeDao();
			list = notcieDao.selectNoticeList3(conn);
		} catch (SQLException e) {
			System.out.println("getNoticeList3: Exception");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("getNoticeList3: SQLException");
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 공지사항 목록
	public List<Notice> getNoticeList() {
		List<Notice> list = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			notcieDao = new NoticeDao();
			list = notcieDao.selectNoticeList(conn);
		} catch (SQLException e) {
			System.out.println("getNoticeList: Exception");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("getNoticeList: SQLException");
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
