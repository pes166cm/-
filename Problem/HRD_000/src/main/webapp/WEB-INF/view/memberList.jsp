<%@ page import="vo.MemberVO"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="master/header.jsp"/>

<section>
	<div class="container">
		<p class="title">회원목록조회/수정</p>
		
<%
			ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list"); 
			//System.out.println("jsp list 값 : " + list);
			if(!list.isEmpty()){
%>
		<table width="900px">
			<tr>
				<td>회원번호</td>
				<td>회원성명</td>
				<td>회원전화</td>
				<td>회원주소</td>
				<td>가입일자</td>
				<td>고객등급</td>
				<td>거주지역</td>
			</tr>
			
<%
		for(MemberVO member : list){
			request.setAttribute("member", member);
			
%>
			<tr>
				<td><a href="/memberUpdate?custno=${member.custno}" color="#263238">${member.custno}</a></td>
				<td>${member.custname}</td>
				<td>${member.phone}</td>
				<td>${member.address}</td>
				<td>${member.joindate}</td>
				<td>${member.grade}</td>
				<td>${member.city}</td>
			</tr>
		
<%
		} 
%>
		</table>
	
<% 
		} else {
%>
	
		<p style="text-align:center">등록된 회원 정보가 없습니다.</p>
	
<% 
		}  
%>
	
	</div>
</section>

<jsp:include page="master/footer.jsp"/>
