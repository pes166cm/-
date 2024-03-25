package com.dev.biz;

import java.util.ArrayList;

import com.dev.dao.MemberDao;
import com.dev.vo.MemberVO;

public class MemberService {

	MemberDao dao = new MemberDao();
	
	public int memberInsert(MemberVO member) {
		int n = dao.memberInsert(member);
		return n;
	}
	
	public MemberVO memberSearch(String id) {
		MemberVO member = dao.memberSearch(id);
		return member;
	}
	
	public int memberUpdate(MemberVO member) {
		int n = dao.memberUpdate(member);
		return n;
	}
	
	public int memberDelete(String id) {
		int n = dao.memberDelete(id);
		return n;
	}
	
	public ArrayList<MemberVO> memberList(){
		MemberDao dao = new MemberDao();
		ArrayList<MemberVO> list = dao.memberList();
		return list;
	}
	
	
	
}
