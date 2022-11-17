package com.example.dao;

import com.example.bean.MemberVO;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String BOARD_INSERT = "insert into MEMBER (uname, uid, password, pnum, gender, photo) values (?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update MEMBER set uname=?, uid=?, password=?, pnum=?, photo=? where seq=?";
	private final String BOARD_DELETE = "delete from MEMBER  where seq=?";
	private final String BOARD_GET = "select * from MEMBER  where seq=?";
	private final String BOARD_LIST = "select * from MEMBER order by seq desc";

	public int insertBoard(MemberVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getUname());
			stmt.setString(2, vo.getUid());
			stmt.setString(3, vo.getPassword());
			stmt.setString(4, vo.getPnum());
			stmt.setString(5, vo.getGender());
			stmt.setString(6, vo.getPhoto());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(MemberVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(MemberVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getUname());
			stmt.setString(2, vo.getUid());
			stmt.setString(3, vo.getPassword());
			stmt.setString(4, vo.getPnum());
			stmt.setString(5, vo.getPhoto());
			stmt.setInt(6, vo.getSeq());

			System.out.println(vo.getUname() + "-" + vo.getUid() + "-" + vo.getPassword() + "-" + vo.getPnum() + "-" + vo.getSeq() + "-" + vo.getPhoto());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public MemberVO getBoard(int seq) {
		MemberVO one = new MemberVO();
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("seq"));
				one.setUname(rs.getString("uname"));
				one.setUid(rs.getString("uid"));
				one.setPassword(rs.getString("password"));
				one.setPnum(rs.getString("pnum"));
				one.setGender(rs.getString("gender"));
				one.setCnt(rs.getInt("cnt"));
				one.setPhoto(rs.getString("photo"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<MemberVO> getBoardList(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MemberVO one = new MemberVO();
				one.setSeq(rs.getInt("seq"));
				one.setUname(rs.getString("uname"));
				one.setUid(rs.getString("uid"));
				one.setPassword(rs.getString("password"));
				one.setPnum(rs.getString("pnum"));
				one.setGender(rs.getString("gender"));
				one.setPhoto(rs.getString("photo"));
				one.setRegdate(rs.getDate("regdate"));
				one.setCnt(rs.getInt("cnt"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	public String getPhotoFilename(int sid) {
		System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
		String filename = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, sid);
			rs = stmt.executeQuery();
			if(rs.next()){
				filename = rs.getString("photo");
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}
}
