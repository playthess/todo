package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import service.NoticeService;
import vo.Member;
import vo.Notice;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	private NoticeService noticeService;// 공지사항 출력하기 위해
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login 폼페이지
		// 로그인이 되어 있으면 처리불가
		HttpSession session = request.getSession();
		// 로그인이 되어있는 상태
		if(session.getAttribute("loginMember") != null) { 
			response.sendRedirect(request.getContextPath()+"/memer/calendar");
			return;
		}
		// 공지사항을 출력
		noticeService = new NoticeService();
		List<Notice> noticeList = noticeService.getNoticeList3();
		request.setAttribute("noticeList", noticeList);
	      
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login 
		// 로그인 되어 있으면 처리불가
		HttpSession session = request.getSession();
		// 로그인 되어있는 상태
		if(session.getAttribute("loginMember") != null) { 
			response.sendRedirect(request.getContextPath()+"/member/calendar");
			return;
		}
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		Member paramMember = new Member();
		paramMember.setMemberId(memberId);
		paramMember.setMemberPw(memberPw);
		memberService = new MemberService();
		Member loginMember = memberService.login(paramMember);
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		session.setAttribute("loginMember", loginMember);
		response.sendRedirect(request.getContextPath()+"/member/calendar");
	}

}
