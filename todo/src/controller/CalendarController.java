package controller;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CalendarService;
import service.TodoService;
import vo.Member;

@WebServlet("/member/calendar")
public class CalendarController extends HttpServlet {
	private CalendarService calendarService;
	private TodoService todoService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentYear = request.getParameter("currentYear");
		String currentMonth = request.getParameter("currentMonth");
		String option = request.getParameter("option");
		
		// 디버깅
		System.out.println("currentYear:" + currentYear);
		System.out.println("currentMonth:"+ currentMonth);
		System.out.println("option:"+ option);
		
		calendarService = new CalendarService();
		
		String memberId = ((Member)request.getSession().getAttribute("loginMember")).getMemberId();
		System.out.println("memberId:"+ memberId);
		 
		Map<String, Object> map = calendarService.getTargetCalendar(memberId, currentYear, currentMonth, option);
		
		// 모델
		request.setAttribute("targetYear", map.get("targetYear"));
		request.setAttribute("targetMonth", map.get("targetMonth"));
		request.setAttribute("endDay", map.get("endDay"));
		// 캘린더를 출력할때 필요 공백
		request.setAttribute("startBlank", map.get("startBlank"));
		request.setAttribute("endBlank", map.get("endBlank"));
		// 캘린더에 출력할 모델 목록
		request.setAttribute("todoList", map.get("todoList"));
		request.getRequestDispatcher("/WEB-INF/view/calendar.jsp").forward(request, response);
	}
}
