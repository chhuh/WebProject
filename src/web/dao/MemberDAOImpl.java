package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.util.MyException;
import web.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	DataSource ds;
	
	private static MemberDAOImpl instance;
	
	public static MemberDAOImpl getInstance() {
		if(instance==null) {
			instance = new MemberDAOImpl();
		}
		return instance;
	}
	
	public MemberDAOImpl() {
		try {
			Context ic = new InitialContext();
			Context ic2 = (Context)ic.lookup("java:comp/env");
			ds=(DataSource)ic2.lookup("myDB");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void memberInsert(MemberVO memberVO) throws MyException{
		try(Connection con = ds.getConnection()){
			String sql = "insert into member(name,email,pw,userType,fl) values(?,?,?,'member', ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, memberVO.getName());
			stmt.setString(2, memberVO.getEmail());
			stmt.setString(3, memberVO.getPw());
			stmt.setString(4, memberVO.getFl());
			int i = stmt.executeUpdate();
			System.out.println(i+"행이 insert되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("회원가입 실패");
		}
		
	}


	public MemberVO login(MemberVO memberVO) throws MyException{
		try(Connection con = ds.getConnection()){
			String sql = "select no,name,userType from member where email=? and pw=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, memberVO.getEmail());
			stmt.setString(2, memberVO.getPw());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				memberVO.setNo(rs.getInt("no"));
				memberVO.setName(rs.getString("name"));
				memberVO.setUserType(rs.getString("userType"));
				return memberVO;
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("login 실패");
		}
		
	}

	@Override
	public MemberVO getMember(String name) throws MyException {
		try(Connection con = ds.getConnection()){
			String sql = "select name,email,pw,fl from member where name=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			MemberVO memberVO = new MemberVO();
			if(rs.next()) {
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPw(rs.getString("pw"));
				memberVO.setFl(rs.getString("fl"));
				return memberVO;
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("정보조회 실패");
		}
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws MyException {
		try(Connection con = ds.getConnection()){
			String sql = "update member set email=?, pw=?, fl=? where name=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, memberVO.getEmail());
			stmt.setString(2, memberVO.getPw());
			stmt.setString(3, memberVO.getFl());
			stmt.setString(4, memberVO.getName());
			int i = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("우리는 실패하지 않았다.");
		}
	}

	@Override
	public void deleteMember(String name) throws MyException {
		try(Connection con = ds.getConnection()){
			String sql = "delete from member where name=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("우리는 실패하지 않았다.");
		}
		
	}

}
