package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	private Member member;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		//디버깅
		System.out.println("memberId:"+ memberId);
		System.out.println("memberPw:"+ memberPw);
		
		member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		//디버깅
		System.out.println("memeber:"+ member);
		
		memberService = new MemberService();
		memberService.insertMember(member);
		//디버깅
		System.out.println("memberService:"+ memberService);
	
		response.sendRedirect(request.getContextPath()+"/login");
		
		
	}

}
