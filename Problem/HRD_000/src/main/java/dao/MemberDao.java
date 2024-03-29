package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import vo.MemberMoneyVO;
import vo.MemberVO;

public class MemberDao {

	public ArrayList<MemberVO> memberList(){
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select custno, custname, phone, address, joindate, decode(grade,'A','VIP','B','일반','C','직원') grade,city \r\n"
					+ "from MEMBER_TBL_02 order by custno" );
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return list;
	}
	
	public ArrayList<MemberMoneyVO> memberMoneyList(){
		ArrayList<MemberMoneyVO> Moneylist = new ArrayList<MemberMoneyVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select A.custno, A.custname, decode(grade,'A','VIP','B','일반','C','직원') grade, sum(B.price) price\r\n"
					+ "from member_tbl_02 A, money_tbl_02 B \r\n"
					+ "where A.custno = B.custno\r\n"
					+ "group by A.custno, A.custname, A.grade \r\n"
					+ "order by price desc");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberMoneyVO vo = new MemberMoneyVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setGrade(rs.getString("grade"));
				vo.setPrice(rs.getInt("price"));
				Moneylist.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return Moneylist;
	}

	public int getMaxCustNo() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int custno = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select max(custno)+1 custno from MEMBER_TBL_02");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				custno = rs.getInt("custno");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return custno;
		
	}
	
	public int memberInsert(MemberVO member) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			System.out.println("이건 member의 Custname == " + member.getCustname());
			System.out.println("이건 member의 phone == " + member.getPhone());
			System.out.println("이건 member의 address == " + member.getAddress());
			System.out.println("이건 member의 joindate == " + member.getJoindate());
			System.out.println("이건 member의 grade == " + member.getGrade());
			System.out.println("이건 member의 city == " + member.getCity());
			System.out.println("이건 member의 custno == " + member.getCustno()); 
			
			ps = conn.prepareStatement("insert into member_tbl_02 values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, member.getCustno());
			ps.setString(2, member.getCustname());
			ps.setString(3, member.getPhone());
			ps.setString(4, member.getAddress());
			ps.setDate(5, member.getJoindate());
			ps.setString(6, member.getGrade());
			ps.setString(7, member.getCity());
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
	
	public MemberVO getMember(int custno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		//System.out.println(custno);
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select custno, custname, phone, address, joindate, grade, city \r\n"
										+ " from MEMBER_TBL_02 where custno = ?");
			
			ps.setInt(1, custno);
			rs = ps.executeQuery();

			while(rs.next()) {
				vo = new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps);
		}
		return vo;
		
	}
	
	public int memberUpdate(MemberVO member) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			//System.out.println("이건 member의 custname" + member.getCustname());
			ps = conn.prepareStatement("Update member_tbl_02 set custname=?,phone=?,address=?,joindate=?,grade=?,city=? where custno=?");
			ps.setString(1, member.getCustname());
			ps.setString(2, member.getPhone());
			ps.setString(3, member.getAddress());
			ps.setDate(4, member.getJoindate());
			ps.setString(5, member.getGrade());
			ps.setString(6, member.getCity());
			ps.setInt(7, member.getCustno());
			n = ps.executeUpdate();
			
			if(n>0) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			DBUtils.close(conn, ps);
		}
		return n;
	} 
	
}
