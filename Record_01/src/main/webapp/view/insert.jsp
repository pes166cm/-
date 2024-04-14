<%@page import="dao.CourseDao"%>
<%@page import="vo.DateTable_1VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
<%
	CourseDao dao = new CourseDao();
	int id = dao.getMaxCustTable_3();
%>
<section>
<div class="container">
	<p class="title">기록하기</p>
	<form action="/courseInsert" method="post" name="frm">
		<table width="1000px">
			<tr>
				<td>글번호(자동발생)</td>
				<td><input type="number"  value="<%= id %>" name="id" id="id" readonly="readonly"></td>
			</tr>
			  
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" id="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" id="content"></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td><input type="text" name="to_day" id="to_day"></td>
			</tr>
			<tr>
				<td>공개여부</td>
				<td>
					<input type="radio" name="ox" id="ox" value="0" checked="checked" >공개
					<input type="radio" name="ox" id="ox" value="1">비공개
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글 올리기" onclick="return checkForm()">
				</td>
			</tr>
		</table>
	</form>
</div>
</section>
<<script>
		function checkForm() {
			if(document.frm.title.value == ""){
				alert('제목을 입력해주세요.');
				document.frm.title.focus();
				return false;
			}
			if(document.frm.content.value == ""){
				alert('내용을 입력해주세요.');
				document.frm.content.focus();
				return false;
			}
			if(document.frm.to_day.value == ""){
				alert('작성날짜를 입력해주세요.');
				document.frm.to_day.focus();
				return false;
			}
			document.frm.submit();
		}
</script>


<jsp:include page="master/footer.jsp"/>

    