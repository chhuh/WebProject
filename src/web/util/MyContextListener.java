package web.util;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import web.dao.HouseDAO;
import web.dao.HouseDAOImpl;
import web.dao.NoticeDAO;
import web.dao.NoticeDAOImpl;
import web.dao.StoreDAO;
import web.dao.StoreDAOImpl;
import web.vo.HouseVO;
import web.vo.NoticeVO;
import web.vo.StoreVO;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
public class MyContextListener implements ServletContextListener {

    public MyContextListener() {
        System.out.println("MyContextListener() 호출됨");
    }

	public void contextDestroyed(ServletContextEvent sce)  { 
		System.out.println("contextDestroyed() 호출됨");
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("contextInitialized() 호출됨");
		NoticeDAO noticeDAO = NoticeDAOImpl.getInstance();
		
		ServletContext application = sce.getServletContext();
		
		ArrayList<NoticeVO> list = (ArrayList<NoticeVO>)application.getAttribute("noticeList");
		if(list==null){
			list = noticeDAO.getNoticeList();
			application.setAttribute("noticeList",list);
			System.out.println("공지사항 리스트 DB에서 가져오기");
		}
		
		HouseDAO houseDAO = HouseDAOImpl.getInstance();
		
		application = sce.getServletContext();
		
		ArrayList<HouseVO> list2 = (ArrayList<HouseVO>)application.getAttribute("houseList");
		if(list2==null){
			list2 = houseDAO.getHouseList();
			application.setAttribute("houseList",list2);
			System.out.println("아파트 리스트 DB에서 가져오기");
		}
		
		StoreDAO storeDAO = StoreDAOImpl.getInstance();
		
		application = sce.getServletContext();
		
		ArrayList<StoreVO> list3 = (ArrayList<StoreVO>)application.getAttribute("storeList");
		if(list3==null){
			list3 = storeDAO.getStoreList();
			application.setAttribute("storeList",list3);
			System.out.println("상권 리스트 DB에서 가져오기");
		}
    }
	
}
