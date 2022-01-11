package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao {
	// 회원탈퇴 메소드
	public int deleteMember(Connection conn, String memberId, String memberPw) throws SQLException {
		String sql = MemberQuery.DELETE_MEMBER;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.setString(2, memberPw);
		int row = stmt.executeUpdate();
		stmt.close();
		return row;
	}
	// 로그인 메소드
	public Member login(Connection conn, Member paramMember) throws SQLException {
		Member loginMember = null;
		String sql = MemberQuery.LOGIN;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, paramMember.getMemberId());
		stmt.setString(2, paramMember.getMemberPw());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			loginMember = new Member();
			loginMember.setMemberId(rs.getString("memberId"));
		}
		rs.close();
		stmt.close();
		return loginMember;
	}
	// 추가 메소드
	public Member insertMember(Connection conn, Member member) throws SQLException {
		Member m = null;
		String sql = MemberQuery.INSERT_MEMBER;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPw(rs.getString("member_pw"));
				m.setCreateDate(rs.getString("create_date"));
				m.setUpdateDate(rs.getString("update_date"));
			}
			return m;
	}
	// 아이디 중복검사
	public boolean memberIdCheckDao(Connection conn, String memberId) throws SQLException {
		System.out.println("MemberDao memberIdCheckDao memberId : "+ memberId);
		
		boolean result = true;
		
		// 아이디가 존재할 시 false 반환
		String sql = MemberQuery.SELECT_MEMBER_ID;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) { // 값이 존재하면
			result = false;
			return result;
		}

		return result;
	}
}
