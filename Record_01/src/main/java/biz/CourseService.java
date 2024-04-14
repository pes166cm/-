package biz;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CourseDao;
import vo.DateTable_1VO;
import vo.DateTable_3VO;

public class CourseService {
	
	CourseDao dao = new CourseDao();

	
	public int getMaxCustNo() {
		int id = dao.getMaxCustNo();
		return id;
	}
	
	public ArrayList<DateTable_3VO> courseList(){
		ArrayList<DateTable_3VO> list = dao.courseList();
		return list;
	}
	
	public int courseInsertMember(DateTable_1VO course) throws SQLException {
		int n = dao.CourseInsertMember(course);
		return n;
	}
	
	public int courseInsert(DateTable_3VO table_3) throws SQLException {
		int n = dao.CourseInsert(table_3);
		return n;
	}
	
	public int courseUpdate(DateTable_3VO table_3) throws SQLException {
		int n = dao.courseUpdate(table_3);
		return n;
	}
	
	
	public DateTable_3VO getTable_3(int id) {
		DateTable_3VO table_3 = dao.getTable_3(id);
		return table_3;
	}

	public int courseDelete(int id) {
		int n = dao.courseDelete(id);
		return n;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
