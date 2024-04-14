package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CourseService;
import vo.DateTable_1VO;

public class CourseInsertMemberController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			return  processInsertServic(req, resp);
		}else if (req.getMethod().equals("GET")) {
			
			return "insertmember";
		}
		return "redirect::/";
	}

	private String processInsertServic(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");		
		String pw = req.getParameter("pw");
		String pnum = req.getParameter("pnum");
		String mail = req.getParameter("mail");
		
		DateTable_1VO table_1 = new DateTable_1VO();
		table_1.setId(id);
		table_1.setName(name);
		table_1.setPw(pw);
		table_1.setPnum(pnum);
		table_1.setMail(mail);
		
		
		CourseService service = new CourseService();
		int n = 0; 
		try {
			n = service.courseInsertMember(table_1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(n>0) {
			return "redirect::courseList";
		} else {
			return "insertmember";
		}
	
	}

	private String processInsertMemberView(HttpServletRequest req, HttpServletResponse resp) {
		CourseService service = new CourseService();
		int id = service.getMaxCustNo();
		req.setAttribute("id", id);
		
		return "insertmember";
	}
	
	
}
