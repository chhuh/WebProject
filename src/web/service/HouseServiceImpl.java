package web.service;

import java.util.List;

import web.dao.HouseDAO;
import web.dao.HouseDAOImpl;
import web.util.PageNavigation;
import web.vo.HouseVO;
import web.vo.ListParameterVO;

public class HouseServiceImpl implements HouseService {
	
	private HouseDAO houseDAO = HouseDAOImpl.getInstance();
	
	private static HouseService guestBookService = new HouseServiceImpl();
	
	private HouseServiceImpl() {}

	public static HouseService getGuestBookService() {
		return guestBookService;
	}

	@Override
	public List<HouseVO> listArticle(String pg, String key, String word) throws Exception {
		int pgno = pg != null ? Integer.parseInt(pg) : 1;
		int countPerPage = 10;
		int start= (pgno - 1) * countPerPage;
		ListParameterVO listParameterVO = new ListParameterVO();
		listParameterVO.setKey(key == null ? "" : key.trim());
		listParameterVO.setWord(word == null ? "" : word.trim());
		listParameterVO.setStart(start);
		listParameterVO.setCurrentPerPage(countPerPage);
		return houseDAO.listArticle(listParameterVO);
	}
	
	@Override
	public PageNavigation makePageNavigation(String pg, String key, String word) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();
		int currentPage = pg != null ? Integer.parseInt(pg) : 1;
		int naviSize = 5;
		int countPerPage = 10;
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setCountPerPage(countPerPage);
		pageNavigation.setNaviSize(naviSize);
		
		ListParameterVO listParameterVO = new ListParameterVO();
		listParameterVO.setKey(key == null ? "" : key.trim());
		listParameterVO.setWord(word == null ? "" : word.trim());
		
		int totalCount = houseDAO.getTotalCount(listParameterVO);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / countPerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setStartRange(currentPage <= naviSize);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public HouseVO getArticle(int articleNo) throws Exception {
		return houseDAO.getArticle(articleNo);
	}
	

}




















