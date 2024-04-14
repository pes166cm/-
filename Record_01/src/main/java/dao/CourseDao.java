package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import vo.DateTable_1VO;
import vo.DateTable_3VO;

public class CourseDao {
	
	public int getMaxCustNo() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select max(id)+1 id from datetable_1");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return id;
	}
	
	public int getMaxCustTable_3() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select max(id)+1 id from datetable_3");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return id;
	}
	
	public int CourseInsertMember(DateTable_1VO table_1) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("Insert into dateTable_1 values(?,?,?,?,?)");
			ps.setInt(1, table_1.getId());
			ps.setString(2, table_1.getName());
			ps.setString(3, table_1.getPw());
			ps.setString(4, table_1.getPnum());
			ps.setString(5, table_1.getMail());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			DBUtils.close(conn, ps);
		}
		return n;
		
	}
	
	public ArrayList<DateTable_3VO> courseList() {
		ArrayList<DateTable_3VO> list = new ArrayList<DateTable_3VO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select id, title, content, substr(to_day,1,4)||'년 '||substr(to_day,5,2)||'월 '||substr(to_day,7,2)||'일' to_day,  decode(ox,0,'공개',1,'비공개') ox from datetable_3 order by id asc");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DateTable_3VO vo = new DateTable_3VO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setTo_day(rs.getString("to_day"));
				vo.setOx(rs.getString("ox"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return list;
	}
	
	public int CourseInsert(DateTable_3VO table_3) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" Insert into dateTable_3 values(?,?,?,?,?)");
			ps.setInt(1, table_3.getId());
			ps.setString(2, table_3.getTitle());
			ps.setString(3, table_3.getContent());
			ps.setString(4, table_3.getTo_day());
			ps.setString(5, table_3.getOx());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			DBUtils.close(conn, ps);
		}
		return n;
		
	}
	
	public DateTable_3VO getTable_3(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DateTable_3VO vo = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select id, title, content, to_day, ox from datetable_3 where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new DateTable_3VO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setTo_day(rs.getString("to_day"));
				vo.setOx(rs.getString("ox"));
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return vo;
	
	}
	
	public int courseUpdate(DateTable_3VO table_3) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" Update datetable_3 set title=?, content=?, to_day=?, ox=? where id=?");
			ps.setString(1, table_3.getTitle());
			ps.setString(2, table_3.getContent());
			ps.setString(3, table_3.getTo_day());
			ps.setString(4, table_3.getOx());
			ps.setInt(5, table_3.getId());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			DBUtils.close(conn, ps);
		}
		return n;
		
	}
	
	public int courseDelete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			String sql = " Delete from datetable_3 where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			n = ps.executeUpdate();
			if(n>0) {
				DBUtils.commit(conn);
			}
		} catch(Exception e) {
			DBUtils.rollack(conn);
		} finally {
			DBUtils.close(conn, ps);
		}
		return n;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
