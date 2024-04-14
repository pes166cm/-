package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CourseService;
import vo.DateTable_3VO;

public class CourseUpdateController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			return  processUpdateServic(req, resp);
		}else if (req.getMethod().equals("GET")) {
			return processInsertView(req, resp);
		}
		return "redirect::/";
	}
		
		private String processUpdateServic(HttpServletRequest req, HttpServletResponse resp) {
			int id = Integer.parseInt(req.getParameter("id"));
			String title = req.getParameter("title");
			String content  = req.getParameter("content");
			String to_day = req.getParameter("to_day");
			String ox = req.getParameter("ox");
			
			DateTable_3VO table_3 = new DateTable_3VO();
			table_3.setId(id);
			table_3.setTitle(title);
			table_3.setContent(content);
			table_3.setTo_day(to_day);
			table_3.setOx(ox);
			
			CourseService service = new CourseService();
			int n = 0;
			try {
				n = service.courseUpdate(table_3);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			if(n>0) {
				return "redirect::courseList";
			} else {
				return "update";
			}
		}	
			private String processInsertView(HttpServletRequest req, HttpServletResponse resp) {
				int id = Integer.parseInt(req.getParameter("id"));

				CourseService service = new CourseService();
				DateTable_3VO table_3 = service.getTable_3(id);
				req.setAttribute("table_3", table_3);
				
				return "update";
				
			}
			
}
