package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.biz.MemberService;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MemberService service = new MemberService();
		int n = service.memberDelete(id);
		if(n > 0) {
			req.setAttribute("id", id);
			HttpUtil.forward(req, resp, "/view/memberDeleterOutput.jsp");
		} else {
			req.setAttribute("error", "회원정보 삭제 오류 입니다.");
			HttpUtil.forward(req, resp, "/view/memberDelete.jsp");
		}
		
	}
	
}
