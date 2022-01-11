package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import commons.DBUtil;
import dao.TodoDao;
import vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	
	// todo 리스트
	public List<Todo> getTodoListByDate(Todo todo) {
		List<Todo> list = null;
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			todoDao = new TodoDao();
			list = todoDao.selectTodoListByDate(conn, todo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		return list;
	}
	// todo 추가
	public void insertTodo(Todo todo) {
		Connection conn = null;

		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			todoDao = new TodoDao();
			todoDao.insertTodo(conn, todo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void deleteTodoList(int todoNo) {
		Connection conn =null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			todoDao = new TodoDao();
			todoDao.deleteTodoList(conn, todoNo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void getupdateTodoList(Todo todo) {
		Connection conn = null;
		try {
			conn =  DBUtil.getConnection("jdbc:mariadb://52.79.208.222/todo", "root", "java1004");
			todoDao = new TodoDao();
			todoDao.updateTodoList(conn, todo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e)  {
				e.printStackTrace();
			}
		}
	}
}
