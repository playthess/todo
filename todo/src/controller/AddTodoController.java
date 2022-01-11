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


@WebServlet("/member/addTodo")
public class AddTodoController extends HttpServlet {
	private TodoService todoService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		todoService = new TodoService();
		String todoDate = request.getParameter("todoDate");
		String todoContent = request.getParameter("todoContent");
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		
		// 일정 관련 데이터 객체에 담기
		Todo todo = new Todo();
		todo.setMemberId(memberId);
		todo.setTodoDate(todoDate);
		todo.setTodoContent(todoContent);
		
		// 일정 추가
		todoService.insertTodo(todo);
		
		// todoDate 문자열 자르기로 년,월,일 뽑기
		String y = todoDate.substring(0,4);
		String m = todoDate.substring(5,7);
		String d = todoDate.substring(8,10);
		
		// 해당 날짜의 일정 목록으로 돌아가기
		response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d);
		
	}

}