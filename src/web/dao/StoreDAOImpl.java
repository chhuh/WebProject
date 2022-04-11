package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.vo.StoreVO;

public class StoreDAOImpl implements StoreDAO{
	DataSource ds;
	
	private static StoreDAOImpl instance;
	
	public static StoreDAOImpl getInstance() {
		if(instance==null) {
			instance = new StoreDAOImpl();
		}
		return instance;
	}
	
	public StoreDAOImpl() {
		try {
			Context ic = new InitialContext();
			Context ic2 = (Context)ic.lookup("java:comp/env");
			ds=(DataSource)ic2.lookup("myDB");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<StoreVO> getStoreList(){
		try(Connection con=ds.getConnection()){
			String sql="select * from store where sttype=\"음식\" limit 10";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<StoreVO> list = new ArrayList<>();
			while(rs.next()) {
				list.add(new StoreVO(rs.getString("stname"),rs.getString("sttype"),rs.getString("fulljibun")));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
