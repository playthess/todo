package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import vo.Notice;

@WebServlet("/member/logout")
public class LogoutController extends HttpServlet {
	// 공지사항 출력하기 위해서
	private NoticeService noticeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 공지 사항을 출력
		noticeService = new NoticeService();
		List<Notice> noticeList = noticeService.getNoticeList3();
		request.setAttribute("noticeList", noticeList);
		request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

}
