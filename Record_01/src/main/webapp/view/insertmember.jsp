<%@page import="dao.CourseDao"%>
<%@page import="vo.DateTable_1VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
<%
	CourseDao dao = new CourseDao();
	int id = dao.getMaxCustNo();
%>
<section>
<div class="container">
	<p class="title">회원가입</p>
	<form action="/courseInsertMember" method="post" name="frm">
		<table width="1000px">
			<tr>
				<td>글번호(자동발생)</td>
				<td><input type="number" value="<%= id %>" name="id" id="id" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" id="pw"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="pnum" id="pnum"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="mail" id="mail"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="가입하기" onclick="return checkForm()">
				</td>
			</tr>
		</table>
	</form>
</div>
</section>

<script>
	function checkForm(){
		if(document.frm.name.value.trim() == ""){
			alert('이름이 입력되지 않았습니다!');
			document.frm.name.focus();
			return false;
		}	
		if(document.frm.pw.value.trim() == ""){
			alsrt('비밀번호가 입력되지 않았습니다!');
			document.frm.pw.focus();
			return false;
		}
		if(document.frm.pnum.value.trim() == ""){
			alsrt('전화번호가 입력되지 않았습니다!');
			document.frm.pnum.focus();
			return false;
		}
		if(document.frm.mail.value > 1){
			alsrt('이메일이 입력되지 않았습니다!');
			document.frm.mail.focus();
			return false;
		}
		document.frm.submit();
	}
</script>
<jsp:include page="master/footer.jsp"/>

    