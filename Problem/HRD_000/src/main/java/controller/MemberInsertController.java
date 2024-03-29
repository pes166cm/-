package controller;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.MemberService;
import vo.MemberVO;

public class MemberInsertController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		 if(req.getMethod().equals("POST")) {
			 return processInsertService (req, resp);
		 } else if(req.getMethod().equals("GET")) {
			 return processInsertView(req, resp);
		 }
		 
		 return "redirect::/";
	}
	
	private String processInsertService(HttpServletRequest req, HttpServletResponse resp) {
		int custno = Integer.parseInt(req.getParameter("custno"));
		String custname = req.getParameter("custname");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		Date joindate = Date.valueOf(req.getParameter("joindate"));
		String grade = req.getParameter("grade");
		String city = req.getParameter("city");

		//System.out.println("Insert Controller ==> " + custno);
		//System.out.println("Insert Controller ==> " + custname);
		//System.out.println("Insert Controller ==> " + phone);
		//System.out.println("Insert Controller ==> " + address);
		//System.out.println("Insert Controller ==> " + joindate);
		//System.out.println("Insert Controller ==> " + grade);
		//System.out.println("Insert Controller ==> " + city); 다 나옴
		
		MemberVO member = new MemberVO();
		member.setCustno(custno);
		member.setCustname(custname);
		member.setPhone(phone);
		member.setAddress(address);
		member.setJoindate(joindate);
		member.setGrade(grade);
		member.setCity(city);
		
		MemberService service = new MemberService();
		int n = 0;
		
		try {
			n = service.memberInsert(member);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(n > 0) {
			return "redirect::memberList";
		} else {
			return "memberInput";
		}	
	}

	private String processInsertView(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = new MemberService();
		int custno = service.getMaxCustNo();
		req.setAttribute("custno", custno);
		
		return "memberInput";
	}
	
}
