<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../menu.jsp"/>

<c:if test="${!empty error}">
<div class="alert alert-warninng alert-dismissible">
	<button type="button" class="close" data-dismiss="alert">&times;</button>
	<strong>Warning! </strong>${error}
</div>
</c:if>

<div class="container">
<h3>회원 정보 검색</h3>

<form class="form-inline" action="/memberSearch.do" method="post">
	<label for="id" class="mb-2 mr-sm-2">아이디 : </label>
	<input type="text" name="id" class="form-control mb-2 mr-sm-2" id="id">
	<button type="submit" class="btn btn-primary mb-2">검색</button>	
	<input type="hidden" name="job" value="search"/>
</form>
</div>


