package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;


@WebServlet("/member/removeMember")
public class RemoveController extends HttpServlet {
	  private MemberService memberService;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
      request.getRequestDispatcher("/WEB-INF/view/removeMember.jsp").forward(request, response);
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      Member loginMember = (Member)session.getAttribute("loginMember");
      String memberId = loginMember.getMemberId();
      String memberPw = request.getParameter("memberPw");
      
      // 서비스를 통해 회원 삭제
      MemberService memberService = new MemberService();
      boolean removeTrueFlase = memberService.removeMember(memberId, memberPw);
      System.out.println(removeTrueFlase);
      
      if(removeTrueFlase) {
         // 성공적으로 탈퇴 시 로그아웃으로 이동
         response.sendRedirect(request.getContextPath()+"/member/logout");
         System.out.println("회원탈퇴 성공");
      } else {
         // 탈퇴 실패시 그냥 메인화면(calendar)으로 이동
         response.sendRedirect(request.getContextPath()+"/member/calendar");
         System.out.println("회원탈퇴 실패");
      }     
   }
}