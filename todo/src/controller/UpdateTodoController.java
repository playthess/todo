package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;
import vo.Todo;

@WebServlet("/member/updateTodoList")
public class UpdateTodoController extends HttpServlet {
	private TodoService todoService; 
	private Todo todo;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값 가져오기 
		String todoDate = request.getParameter("todoDate");
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		//디버깅
		System.out.println("todoNo:"+ todoNo);
		
		//겍체생성 
		todo = new Todo();
		todo.setTodoDate(todoDate);
		todo.setTodoNo(todoNo);
		request.setAttribute("todoDate", todoDate);
		request.setAttribute("todoNo", todoNo);
		//디버깅 
		System.out.println("todo:"+ todo);
		
		request.getRequestDispatcher("/WEB-INF/view/updateTodoList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String todoContent = request.getParameter("todoContent");
	String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	String todoDate = request.getParameter("todoDate");
	int todoNo = Integer.parseInt(request.getParameter("todoNo"));
	//디버깅 
	System.out.println("todoContent:"+ todoContent);
	System.out.println("memberId:"+ memberId);
	System.out.println("todoDate:"+ todoDate);
	
	todo = new Todo();
	todo.setTodoDate(todoDate);
	todo.setTodoContent(todoContent);
	todo.setMemberId(memberId);
	todo.setTodoNo(todoNo);
	//디버깅 
	System.out.println("todo:"+ todo);
	
	todoService= new TodoService();
	
	todoService.getupdateTodoList(todo);
	
	
	response.sendRedirect(request.getContextPath()+"/member/calendar");
	}
}
