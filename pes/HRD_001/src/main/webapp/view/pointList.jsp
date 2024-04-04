<%@page import="vo.MemberPointVO"%>
<%@page import="vo.PointVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.tlqkfDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    

<%
	tlqkfDao dao = new tlqkfDao();
	ArrayList<MemberPointVO> memberrank = dao.memberrank();
	//System.out.println("mento jsp의 list ==> " + memberrank);
%>    

<jsp:include page="../master/header.jsp"/>

<section>
<div class="container">
	<p class="title">참가자 등위</p>	
		
		<%
		if(!memberrank.isEmpty()){		
		%>
		
		<table width="900px">
		
			<tr>
				<td>참가자명</td>
				<td>합산점수</td>
				<td>평균</td>
				<td>등위</td>
			</tr>
				
		<%
			for(MemberPointVO renk : memberrank){
		%>
	
			<tr>
				<td><%= renk.getArtist_name() %></td>
				<td><%= renk.getSumpoint() %></td>
				<td><%= renk.getRoundpoint() %></td>
				<td><%= renk.getRanknum() %></td>
			</tr>
		<%
			}
		%>
		
		</table>
		
		<%
		} else{
		%>
		
		<p style="text-align:center">등록된 참가자 등위가 없습니다.</p>
		
		<%
			}
		%>
		
</div>

</section>

<jsp:include page="../master/footer.jsp"/>    