package service;

import java.sql.Connection;
import java.sql.SQLException;

import commons.DBUtil;
import dao.MemberDao;
import dao.TodoDao;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private TodoDao todoDao;
	
	public boolean removeMember(String memberId, String memberPw) {
		boolean result = false;
		Connection conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
		try {
			conn.setAutoCommit(false);
			todoDao = new TodoDao();
			memberDao = new MemberDao();
			todoDao.deleteTodo(conn, memberId);
			if(memberDao.deleteMember(conn, memberId, memberPw) != 1) {
				throw new Exception();
			}
	
			conn.commit();
			result  = true;
		}catch(Exception e ) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result; 
	}
	
	public Member login(Member member) {
		Member loginMember = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			memberDao = new MemberDao();
			loginMember = memberDao.login(conn, member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
	
	public Member insertMember(Member member) {
		Member m = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			memberDao = new MemberDao();
			m = memberDao.insertMember(conn, member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	public boolean memberIdCheckService(String memberId) {
		System.out.println("MemberService memberIdCheckService memberId : "+ memberId);
		
		boolean result = true;
		Connection conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
		try {
			memberDao = new MemberDao();
			
			// 중복 = false
			if(memberDao.memberIdCheckDao(conn, memberId) == false) {
				return false;
			}
			
			result=true;
		}catch(Exception e){
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				System.out.println("[Debug] MemberService memberIdCheckService - conn Exception");
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			}catch(SQLException e){
				System.out.println("[Debug] MemberService memberIdCheckService - SQLException");
				e.printStackTrace();
			}
		}
		return result;
	}
}
