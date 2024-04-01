<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="dao.MemberDao" %>
<%@ page import="vo.MemberVO" %>

<%
		request.setCharacterEncoding("UTF-8");
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Date joindate = Date.valueOf(request.getParameter("joindate"));
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");

		MemberVO member = new MemberVO();
		member.setCustno(custno);
		member.setCustname(custname);
		member.setPhone(phone);
		member.setAddress(address);
		member.setJoindate(joindate);
		member.setGrade(grade);
		member.setCity(city);
	
		MemberDao dao = new MemberDao();
		int n = dao.memberInsert(member);
		
		if(n > 0){
			response.sendRedirect("/view/memberList.jsp");
		}
		else{
			%>
			<script>
				history.back();
			</script>
			<%
		}



%>
