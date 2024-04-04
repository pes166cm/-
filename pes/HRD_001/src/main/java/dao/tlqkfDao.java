package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import vo.ArtistVO;
import vo.MemberPointVO;
import vo.PointVO;

public class tlqkfDao {
	
	public ArrayList<ArtistVO> artistList(){
		ArrayList<ArtistVO> list = new ArrayList<ArtistVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select artist_id,artist_name, \r\n"
					+ "substr(a.artist_birth,1,4) ||'년'||substr(a.artist_birth,5,2)||'월'||substr(a.artist_birth,7,2)||'일' artist_birth,\r\n"
					+ "decode(a.artist_gender,'M','남','F','여') artist_gender,decode(a.talent,'1','보컬','2','댄스','3','랩') talent, a.agency\r\n"
					+ "from tbl_artist_201905 a\r\n"
					+ "order by a.artist_id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ArtistVO vo = new ArtistVO();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setTalent(rs.getString("talent"));
				vo.setAgency(rs.getString("agency"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps ,rs);
		}
		return list;
		
	}
	
	public ArrayList<PointVO> pointList(){
		ArrayList<PointVO> pointlist = new ArrayList<PointVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select c.serial_no, a.artist_name,\r\n"
					+ "	substr(a.artist_birth,1,4)||'년'||substr(a.artist_birth,5,2)||'월'||substr(a.artist_birth,7,2)||'일' artist_birth, c.point,\r\n"
					+ "	case when c.point >= 90 then 'A'\r\n"
					+ "		when c.point >= 80 then 'B'\r\n"
					+ "		when c.point >= 70 then 'C'\r\n"
					+ "		when c.point >= 60 then 'D'\r\n"
					+ "		else 'F' end point_too, \r\n"
					+ "	b.mento_name\r\n"
					+ "from TBL_ARTIST_201905 a, TBL_MENTO_201905 b, TBL_POINT_201905 c\r\n"
					+ "where a.artist_id = c.artist_id and b.mento_id = c.mento_id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PointVO vo = new PointVO();
				vo.setSerial_no(rs.getString("serial_no"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setPoint(rs.getString("point"));
				vo.setPoint_too(rs.getString("point_too"));
				vo.setMento_name(rs.getString("mento_name"));
				pointlist.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps ,rs);
		}
		return pointlist;
		
	}
	
	public int Insert(ArtistVO artist) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("Insert into tbl_artist_201905 values(?,?,?,?,?,?)");
			ps.setString(1, artist.getArtist_id());
			ps.setString(2, artist.getArtist_name());
			ps.setString(3,artist.getArtist_birth());
			ps.setString(4,artist.getArtist_gender());
			ps.setString(5,artist.getTalent());
			ps.setString(6,artist.getAgency());
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
	
	
	public ArrayList<MemberPointVO> memberrank(){
		ArrayList<MemberPointVO> memberrank = new ArrayList<MemberPointVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select a.artist_name, sum(b.point) sumpoint, round(avg(b.point),2) roundpoint, RANK() OVER(order by sum(b.point) desc)  ranknum \r\n"
					+ "from tbl_artist_201905 a, tbl_point_201905 b \r\n"
					+ "where a.artist_id = b.artist_id \r\n"
					+ "group by a.artist_name \r\n"
					+ "order by sum(b.point) desc");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberPointVO vo = new MemberPointVO();
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setSumpoint(rs.getString("sumpoint"));
				vo.setRoundpoint(rs.getString("roundpoint"));
				vo.setRanknum(rs.getString("ranknum"));
				memberrank.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps ,rs);
		}
		return memberrank;
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
