<%@page import="vo.ArtistVO"%>
<%@page import="dao.tlqkfDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

		request.setCharacterEncoding("UTF-8");
		String artist_id = request.getParameter("artist_id");
		String artist_name = request.getParameter("artist_name");
		String artist_birth = request.getParameter("artist_birth");
		String artist_gender = request.getParameter("artist_gender");
		String talent = request.getParameter("talent");
		String agency = request.getParameter("agency");

		ArtistVO artist = new ArtistVO();
		artist.setArtist_id(artist_id);
		artist.setArtist_name(artist_name);
		artist.setArtist_birth(artist_birth);
		artist.setArtist_gender(artist_gender);
		artist.setTalent(talent);
		artist.setAgency(agency);
		
		tlqkfDao dao = new tlqkfDao();
		int n = dao.Insert(artist);
		
		if(n>0){
			response.sendRedirect("/view/artistList.jsp");
		}
		else {
%>
		<script>
			history.back();		
		</script>
<%
			}
%>