package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CourseService;
import vo.DateTable_3VO;

public class CourseListController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		CourseService service = new CourseService();
		ArrayList<DateTable_3VO> list = service.courseList();
		
		req.setAttribute("list", list);
		return "list";
	}
}
