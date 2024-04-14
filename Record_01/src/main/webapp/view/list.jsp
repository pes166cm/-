<%@page import="vo.DateTable_3VO"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="master/header.jsp"/>

<section>
		<div class="container">
			<p class="title">기록목록</p>
<%
	ArrayList<DateTable_3VO> list = (ArrayList<DateTable_3VO>)request.getAttribute("list");
	if(!list.isEmpty()) {
%>		

	<table width="1000px">
		<tr>
			
			<td>글번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>날짜</td>
			<td>공개여부</td>
			<td>수정하기</td>
			<td>삭제하기</td>
		</tr>
		
<%
	for(DateTable_3VO course : list) {
		request.setAttribute("course", course);
%>			
		<tr>
			<td>${course.id }</td>
			<td>${course.title }</td>
			<td>${course.content }</td>
			<td>${course.to_day }</td>	
			<td>${course.ox }</td> 
			<td><a href="/courseUpdate?id=${course.id }">수정</a></td>
			<td><a href="/courseDelete?id=${course.id }">삭제</a></td>													
		</tr>
<%
	}
%>						
	</table>
<%
	}else{
%>		
	<p style="text-align: center"> 등록된 회원 정보가 없습니다</p>
<%
	}
%>
		</div>
</section>


<jsp:include page ="master/footer.jsp"/>