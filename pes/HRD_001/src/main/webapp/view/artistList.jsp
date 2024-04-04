<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.ArtistVO" %>
<%@ page import="dao.tlqkfDao" %>
<%@ page import="java.util.ArrayList" %>
    
<%
	tlqkfDao dao = new tlqkfDao();
	ArrayList<ArtistVO> list = dao.artistList();
	//System.out.println("artist jsp의 list ==> " + list);
%>    
    
<jsp:include page="../master/header.jsp"/>

<section>
	<div class="container">
		<p class="title">참가자목록</p>
		
	<%
		if(!list.isEmpty()){
	%>	
		
		<table width="900px">
			<tr>
				<td>참가자번호</td>
				<td>참가자명</td>
				<td>생년월일</td>
				<td>성별</td>
				<td>특기</td>
				<td>소속사</td>
			</tr>
		
	<%
		for(ArtistVO artist : list){
	%>
			<tr>
				<td><a href=#><%= artist.getArtist_id() %></a></td>
				<td><%= artist.getArtist_name() %></td>
				<td><%= artist.getArtist_birth() %></td>
				<td><%= artist.getArtist_gender() %></td>
				<td><%= artist.getTalent() %></td>
				<td><%= artist.getAgency() %></td>
			</tr>
	<%
		}
	%>
	
		</table>
		
	<%
		} else{
	%>
	
	<p style="text-align: center">등록된 참가자 목록이 없습니다.</p>
	
	<%
		}
	%>
	</div>
</section>

<jsp:include page="../master/footer.jsp"/>