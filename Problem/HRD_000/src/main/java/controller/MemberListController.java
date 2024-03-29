package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.MemberService;
import vo.MemberVO;

public class MemberListController implements Controller {

	@Override 
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService service = new MemberService();
		ArrayList<MemberVO> list = service.memberList();
		
		req.setAttribute("list", list);
		//System.out.println("이건 리스트 : " + list);
		return "memberList";
	}
	
}
