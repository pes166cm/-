package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.common.jdbcTemplate;
import com.dev.vo.MemberVO;

public class MemberDao {

	public int memberInsert(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			conn = jdbcTemplate.getConnection();
			pstmt = conn.prepareStatement("Insert into member values(?,?,?,?)");
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			n = pstmt.executeUpdate();
			if(n>0) {
				jdbcTemplate.commit(conn);
			}
		} catch (Exception e){
			e.printStackTrace();
			jdbcTemplate.rollback(conn);
		} finally {
			jdbcTemplate.close(conn, pstmt);
		}
		return n;
		
	}

	public MemberVO memberSearch(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
				
		try {
			conn = jdbcTemplate.getConnection();
			String sql = "select * from member where id = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcTemplate.close(conn, pstmt, rs);
		}
		return member;
	}
	
	public int memberUpdate(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			conn = jdbcTemplate.getConnection();
			pstmt = conn.prepareStatement("Update member set passwd=?, name=?, mail=? where id=?");
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMail());
			pstmt.setString(4, member.getId());
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			jdbcTemplate.rollback(conn);
		} finally {
			jdbcTemplate.close(conn, pstmt);
		}
		return n;
	}
	
	public int memberDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			conn = jdbcTemplate.getConnection();
			String sql = "Delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			n = pstmt.executeUpdate();
			if(n>0) {
				jdbcTemplate.commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jdbcTemplate.rollback(conn);
		} finally {
			jdbcTemplate.close(conn, pstmt);
		}
		return n;
		
	}
	
	public ArrayList<MemberVO> memberList(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		
		try {
			conn = jdbcTemplate.getConnection();
			String sql = "select * from member order by id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcTemplate.close(conn, pstmt, rs);
		}
		return list;
	}
	
}
