package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.biz.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		System.out.println(id);
		
		if(id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			req.setAttribute("error", "모든 항목을 빠짐없이 입력하세요.");
			HttpUtil.forward(req, resp, "/view/memberInsert.jsp");
			return;			
		}
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		MemberService service = new MemberService();
		int n = service.memberInsert(member);
		
		if(n > 0) {
			req.setAttribute("id", id);
			HttpUtil.forward(req, resp, "/view/memberInsertOutput.jsp");
		} else {
			req.setAttribute("error", "회원입력오류");
			HttpUtil.forward(req, resp, "/view/memberInsert.jsp");
		}
		
	}
	
	
	
}
