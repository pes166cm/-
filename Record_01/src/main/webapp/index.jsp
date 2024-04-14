<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="/view/master/header.jsp"/>
	
	<section>
	<div class="container">
		<p class="title">기록하는 사이트</p>
	
			<form>
				<table width="500px">
					<tr height="50px">
						<td><p>이 사이트가 처음이라면 ==>  <button><a href="/courseInsertMember">회원가입</a></button></p></td>
					</tr>
					<tr height="50px">
						<td><p>이 사이트가 처음이 아니라면 ==>  <button><a href="/courseInsertMember">상진쌤이 로그인은 하지 말라그러셨다.</a></button></p></td>
					</tr>
				</table>
			</form>
	
	</div>
	</section>
<%--
<c:if test="${id != null}">
	<jsp:include page="/view/master/header.jsp"/>
	
	<section>
	<div class="container">
		<p class="title">기록하는 사이트</p>
	
			<p>유후 성공</p>
	
	</div>
	</section>
</c:if>
 --%>
<jsp:include page="/view/master/footer.jsp"/>
