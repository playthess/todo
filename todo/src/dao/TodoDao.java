package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Todo;

public class TodoDao {	
	// 일정삭제
	public void deleteTodo(Connection conn, String memberId) throws SQLException {
		String sql = TodoQuery.DELETE_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.executeUpdate();
		stmt.close();	
	}
	
	//리스트
	public List<Todo> selectTodoListByDate(Connection conn, Todo todo) throws SQLException {
		List<Todo> list = new ArrayList<Todo>();
		String sql = TodoQuery.SELECT_TODO_LIST_BY_DATE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Todo t = new Todo();
			t.setTodoNo(rs.getInt("todoNo"));
			t.setTodoDate(rs.getString("todoDate"));
			t.setTodoContent(rs.getString("todoContent"));
			t.setCreateDate(rs.getString("createDate"));
			t.setUpdateDate(rs.getString("updateDate"));
			list.add(t);
		}
		return list;
	}
	
	//작성
	public void insertTodo(Connection conn, Todo todo) throws SQLException {
		String sql = TodoQuery.INSERT_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoContent());
		stmt.setString(3, todo.getTodoDate());
		stmt.executeUpdate();
		
		stmt.close();
	}
	public List<Todo> selectTodoListByMonth(Connection conn, Todo todo) throws SQLException {
      List<Todo> list = new ArrayList<Todo>();
      String sql = TodoQuery.SELECT_TODO_LIST_BY_MONTH;
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, todo.getMemberId());
      stmt.setString(2, todo.getTodoDate().substring(0,7));
      ResultSet rs = stmt.executeQuery();
      while(rs.next()) {
         Todo t = new Todo();
         t.setTodoDate(rs.getString("todoDate"));
         t.setTodoContent(rs.getString("todoContent5"));
         list.add(t);
      }
      return list;
	}
	// 삭제
	public void deleteTodoList(Connection conn, int todoNo) throws SQLException {
		String sql = TodoQuery.DELETE_TODO_LIST;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,todoNo);		
		stmt.executeUpdate();		
	}
	// 수정
	public void updateTodoList(Connection conn, Todo todo) throws SQLException {
		String sql = TodoQuery.UPDATE_TODO_LIST;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getTodoContent());
		stmt.setString(2, todo.getTodoDate());
		stmt.setString(3, todo.getMemberId());
		stmt.setInt(4,todo.getTodoNo());
		
		ResultSet rs  = stmt.executeQuery();
		if(rs.next()) {
			Todo t = new Todo();
			t.setTodoContent(rs.getString("todo_content"));
			t.setTodoDate(rs.getString("todo_date"));
			t.setMemberId(rs.getString("member_Id"));
		}
		
	}
}
