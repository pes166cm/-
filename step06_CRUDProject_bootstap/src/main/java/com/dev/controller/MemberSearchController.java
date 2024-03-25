package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.biz.MemberService;
import com.dev.vo.MemberVO;

public class MemberSearchController implements Controller {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		String path = req.getParameter("path");
		System.out.println(id);
		System.out.println(job);
		System.out.println(path);
		
		if(job.equals("search"))
			path="/view/memberSearch.jsp";
		else if(job.equals("update"))
			path="/view/memberUpdate.jsp";
		else if(job.equals("delete"))
			path="/view/memberDelete.jsp";
		
		if(id.isEmpty()) {
			req.setAttribute("eorre", "ID를 입력해 주시기 바랍니다.");
			HttpUtil.forward(req, resp, path);
			return;
		}
		MemberService service = new MemberService();
		MemberVO member = service.memberSearch(id);
		
		if(member == null) req.setAttribute("error", "검색된 정보가 없습니다.");
		req.setAttribute("member", member);
		if(job.equals("search")) path = "/view/memberSearchOutput.jsp";
		HttpUtil.forward(req, resp, path);
		
	}
	
	
}
