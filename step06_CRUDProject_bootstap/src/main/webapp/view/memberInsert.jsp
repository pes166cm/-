<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../menu.jsp"/>

<div class="container">

<c:if test="${!empty error}">
<div class="alert alert-warninng alert-dismissible">
	<button type="button" class="close" data-dismiss="alert">&times;</button>
	<strong>Warning! </strong>${error}
</div>
</c:if>

<h3>회원 가입</h3>

<form action="/memberInsert.do" method="post">
	<div class="form-group">
		<label for="id">아이디 : </label>
		<input type="text" class="form-control" id="id" name="id">		
	</div>
	<div class="form-group">
		<label for="passwd">비밀번호 : </label>
		<input type="password" class="form-control" id="passwd" name="passwd">		
	</div>
	<div class="form-group">
		<label for="name">이름 : </label>
		<input type="text" class="form-control" id="name" name="name">		
	</div>
	<div class="form-group">
		<label for="mail">이메일 : </label>
		<input type="text" class="form-control" id="mail" name="mail">		
	</div>
	<button type="submit" class="btn btn-primary">추가</button>
	<button type="reset" class="btn btn-primary">취소</button>

</form>
</div>