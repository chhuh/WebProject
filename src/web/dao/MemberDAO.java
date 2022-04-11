package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.util.MyException;
import web.vo.MemberVO;

public interface MemberDAO {
	public void memberInsert(MemberVO memberVO) throws MyException;
	public MemberVO login(MemberVO memberVO) throws MyException;
	public MemberVO getMember(String name) throws MyException;
	public void memberUpdate(MemberVO memberVO) throws MyException ;
	public void deleteMember(String name) throws MyException ;
	
}
