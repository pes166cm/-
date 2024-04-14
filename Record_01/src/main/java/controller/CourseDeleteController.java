package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CourseService;

public class CourseDeleteController implements Controller {
	
		@Override
		public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id = Integer.parseInt(req.getParameter("id"));
			
			CourseService service = new CourseService();
			int n = service.courseDelete(id);
			
			return "redirect::/courseList";
			
		}
		
}
