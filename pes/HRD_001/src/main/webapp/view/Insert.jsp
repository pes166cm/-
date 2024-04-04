<%@page import="dao.tlqkfDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../master/header.jsp"/>

<%
	tlqkfDao dao = new tlqkfDao();
%>

<section>

<div class="container">

	<p class="title">오디션 등록</p>
	
	<form action="InsertInput.jsp" method="post" name="frm">
	
	<table width="700px">
	
			<tr>
				<td>참가번호</td>
				<td><input type="text" name="artist_id" id="artist_id"></td>
			</tr>
	
			<tr>
				<td>참가자명</td>
				<td><input type="text" name="artist_name" id="artist_name"></td>
			</tr>
			
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="artist_birth" id="artist_birth">
				</td>
			</tr>
			
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" id="artist_gender" name="artist_gender" value="M">남
					<input type="radio" id="artist_gender" name="artist_gender" value="F">여
				</td>
			</tr>
			
			<tr>
				<td>특기</td>
				<td>
					<select id="talent" name="talent">
						<option value="null">특기 선택</option>
						<option value="1">보컬</option>
						<option value="2">댄스</option>
						<option value="3">랩</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>소속사</td>
				<td><input type="text" name="agency" id="agency"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="가입하기" onclick="retrun checkForm()">
				<input type="reset" value="다시쓰기">
				</td>
			</tr>
			
			
	</table>
</form>
</div>
</section>

<script>

	function checkForm(){
		if(document.frm.artist_id.value.trim() == ""){
			alert('참가번호가 입력되지 않았습니다.');
		document.frm.artist_id.focus();
		return false;
		}
		if(document.frm.artist_name.value == ""){
			alert('참가자명이 입력되지 않았습니다.!');
		document.frm.artist_name.focus();
		return false;
		}
		if(document.frm.artist_birth.value == ""){
			alert('생년월일이 입력되지 않았습니다.!');
		document.frm.artist_birth.focus();
		return false;
		}
		if(document.frm.artist_gender.value == ""){
			alert('성별이 선택되지 않았습니다.!');
		document.frm.artist_gender.focus();
		return false;
		}
		if(document.frm.talent.value == ""){
			alert('특기가 선택되지 않았습니다.!');
		document.frm.talent.focus();
		return false;
		}
		if(document.frm.agency.value == ""){
			alert('소속사가 입력되지 않았습니다.!');
		document.frm.agency.focus();
		return false;
		}
		document.frm.submit();
		
	}

</script>

<jsp:include page="../master/footer.jsp"/>
