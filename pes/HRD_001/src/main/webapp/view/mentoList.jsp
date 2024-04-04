<%@page import="vo.PointVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.tlqkfDao" %>
<%@ page import="java.util.ArrayList" %>
    
<%
	tlqkfDao dao = new tlqkfDao();
	ArrayList<PointVO> pointlist = dao.pointList();
	//System.out.println("mento jsp의 list ==> " + pointlist);
%>    
    
<jsp:include page="../master/header.jsp"/>

<section>
	<div class="container">
		<p class="title">참가자목록</p>
		
	<%
		if(!pointlist.isEmpty()){
	%>	
		
		<table width="900px">
			<tr>
				<td>참가자번호</td>
				<td>참가자명</td>
				<td>생년월일</td>
				<td>점수</td>
				<td>등급</td>
				<td>멘토</td>
			</tr>
		
	<%
		for(PointVO point : pointlist ){
	%>
			<tr>
				<td><%= point.getSerial_no() %></td>
				<td><%= point.getArtist_name() %></td>
				<td><%= point.getArtist_birth() %></td>
				<td><%= point.getPoint() %></td>
				<td><%= point.getPoint_too() %></td>
				<td><%= point.getMento_name() %></td>
			</tr>
	<%
		}
	%>
	
		</table>
		
	<%
		} else{
	%>
	
	<p style="text-align: center">등록된 참가자 목록이 없습니다.</p>
	
	<%
		}
	%>
	</div>
</section>

<jsp:include page="../master/footer.jsp"/>