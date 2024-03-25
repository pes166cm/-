<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dev.vo.MemberVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../menu.jsp"/>

<div class="container">
<h3>회원 정보</h3>

<c:if test="${!empty list}">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}"  var="member">
			<tr>
				<td>${member.id}</td>
				<td>${member.passwd}</td>
				<td>${member.name}</td>
				<td>${member.mail}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>
<c:if test="${empty list}">
	<h3>등록된 회원 정보가 없습니다.</h3>
</c:if>
</div>




