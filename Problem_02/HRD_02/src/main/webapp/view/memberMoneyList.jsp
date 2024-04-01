<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.MemberMoneyVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.MemberDao" %>

<% 
	MemberDao dao = new MemberDao();
	ArrayList<MemberMoneyVO> list = dao.memberMoneyList();
%>    
<jsp:include page="../master/header.jsp"/>

<section>
	<div class="container">
		<p class="title">회원매출조회</p>
		
		<%
		if(!list.isEmpty()){
		%> 
		
		<table>
			<tr>
				<td>회원번호</td>
				<td>회원성명</td>
				<td>고객등급</td>
				<td>매출</td>
			</tr>
		<%
		for(MemberMoneyVO member:list) {
		%>
			<tr>
				<td><%=member.getCustno() %></td>
				<td><%=member.getCustname() %></td>
				<td><%=member.getGrade() %></td>
				<td><%=member.getPrice() %></td>
			</tr>
			
		<% } %>
		
		</table>
		
		<% } else {  %>
		
		<p style="text-align: center"> 등록된 매출 정보가 없습니다.</p>
	
		<% } %>
	</div>
</section>
    
<jsp:include page="../master/footer.jsp"/>    