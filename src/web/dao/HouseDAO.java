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

public interface HouseDAO {
	public ArrayList<HouseVO> getHouseList();
	public List<HouseVO> listArticle(ListParameterVO listParameterVO);
	public int getTotalCount(ListParameterVO listParameterVO);
	public HouseVO getArticle(int articleNo);

}
