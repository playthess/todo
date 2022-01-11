package dao;

public class AdminQuery {
	public static final String ADMIN_LOGIN;
	public static final String INSERT_NOTICE;
	public static final String UPDATE_NOTICE;
	public static final String DELETE_NOTICE;
	
	static {
		ADMIN_LOGIN = "SELECT admin_id adminId, admin_pw adminPW FROM admin WHERE admin_id=? AND admin_pw=?";
		INSERT_NOTICE = "INSERT INTO notice(notice_no,notice_title,notice_content,create_date,update_date) VALUES(?,?,?,NOW(),NOW())";
		UPDATE_NOTICE = "UPDATE notice SET notice_title=?, notice_content=?, update_date=NOW() WHERE notice_no=?";
		DELETE_NOTICE = "DELETE FROM notice WHERE notice_no=?";
	}
}
