package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.util.MyException;
import web.vo.HouseVO;
import web.vo.ListParameterVO;

public class HouseDAOImpl implements HouseDAO{
	DataSource ds;
	
	private static HouseDAOImpl instance;
	
	public static HouseDAOImpl getInstance() {
		if(instance==null) {
			instance = new HouseDAOImpl();
		}
		return instance;
	}
	
	public HouseDAOImpl() {
		try {
			Context ic = new InitialContext();
			Context ic2 = (Context)ic.lookup("java:comp/env");
			ds=(DataSource)ic2.lookup("myDB");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<HouseVO> getHouseList(){
		try(Connection con=ds.getConnection()){
			String sql="select * from housedeal order by no limit 10";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<HouseVO> list = new ArrayList<>();
			while(rs.next()) {
				list.add(new HouseVO(rs.getInt("no"),rs.getString("aptName"),rs.getString("dealAmount")));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<HouseVO> listArticle(ListParameterVO listParameterVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTotalCount(ListParameterVO listParameterVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public HouseVO getArticle(int articleNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
