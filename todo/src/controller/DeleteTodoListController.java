package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;

/**
 * Servlet implementation class deleteTodoList
 */
@WebServlet("/member/deleteTodoList")
public class DeleteTodoListController extends HttpServlet {
	private TodoService todoservice;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		//디버깅
		System.out.println("todoNo:"+ todoNo);
		
		todoservice = new TodoService();
		todoservice.deleteTodoList(todoNo);
		
		response.sendRedirect(request.getContextPath()+"/member/calendar");
		
	}


}
