package web.dao;

import java.util.*;
import java.sql.*;
import javax.sql.*;

import web.vo.NoticeVO;

import javax.naming.*;

public class NoticeDAOImpl implements NoticeDAO{
	DataSource ds;
	
	private static NoticeDAOImpl instance;
	
	public static NoticeDAOImpl getInstance() {
		if(instance==null) {
			instance=new NoticeDAOImpl();
		}
		return instance;
	}
	
	private NoticeDAOImpl() {
		try {
			Context ic = new InitialContext();
			Context ic2 = (Context)ic.lookup("java:comp/env");
			ds=(DataSource)ic2.lookup("myDB");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<NoticeVO> getNoticeList(){
		try(Connection con=ds.getConnection()){
			String sql="select * from notice order by no limit 5";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<NoticeVO> list = new ArrayList<>();
			while(rs.next()) {
				list.add(new NoticeVO(rs.getInt("no"),rs.getString("title"),rs.getString("content")));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
