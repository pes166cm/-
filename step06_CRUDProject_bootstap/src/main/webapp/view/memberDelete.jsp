<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dev.vo.MemberVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../menu.jsp"/>

<c:if test="${!empty error}">
<div class="alert alert-warninng alert-dismissible">
	<button type="button" class="close" data-dismiss="alert">&times;</button>
	<strong>Warning! </strong>${error}
</div>
</c:if>

<div class="container">
	<form class="corm-inline" action="/memberSearch.do" method="post">
		<label for="id" class="mb-2 mr-sm-2">아이디 : </label>
		<input type="text" name="id" class="form-control mb-2 mr-sm-2" id="id">
		<button type="submit" class="btn btn-primary mb-2">검색</button> 
		<input type="hidden" name="job" value="delete"/>
	</form>
<br>

<% MemberVO member = (MemberVO)request.getAttribute("member");
	if(member != null) {%>

<h3>검색 정보 결과</h3>
${member.id} / ${member.passwd} / ${member.name} /${member.mail} <p>

	<form action="/memberDelete.do" method="post">
		<input type="hidden" name="id" value="${member.id}"/>
		<button type="submit" class="btn btn-primary">삭제</button>
	</form>
<%} else { %>
	${result} <p>
<%} %>

</div>