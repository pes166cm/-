package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FromtController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FrontController() {
		super();
	}
	
	String charset = null;
	HashMap<String, Controller> list = null;
	
	private final String prefix = "/view/";
	private final String postfix = ".jsp";

	@Override
	public void init(ServletConfig config) throws ServletException{
		//System.out.println("프론트 생성");
		charset = config.getInitParameter("charset");
		
		list = new HashMap<String, Controller>();
		list.put("/", new MainController());
		list.put("/courseList", new CourseListController());
		list.put("/courseInsertMember", new CourseInsertMemberController());
		list.put("/courseInsert", new CourseInsertController());
		list.put("/courseUpdate", new CourseUpdateController());
		list.put("/courseDelete", new CourseDeleteController());
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		//System.out.println("프론트 실행");
		req.setCharacterEncoding(charset);
		
		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		
		Controller subController = list.get(path);
		
		if(subController == null) {
			resp.sendRedirect("/");
			return;
		}

	//	System.out.println("이건 path --> " + path);
		String result = subController.execute(req, resp);
	//	System.out.println("이건 result --> " + result);
		
		if(result.indexOf("redirect::") != 0) {
		//	System.out.println(prefix + result + postfix);
			RequestDispatcher dispatcher = req.getRequestDispatcher(prefix + result + postfix);
		//	System.out.println("포워딩 함");
			dispatcher.forward(req, resp);
		} else {
			String reUrl = result.substring("redirect::".length());
			resp.sendRedirect(reUrl);
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
	
	
}
