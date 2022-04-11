package web.service;

import java.util.List;

import web.util.PageNavigation;
import web.vo.HouseVO;



public interface HouseService {

	List<HouseVO> listArticle(String pg, String key, String word) throws Exception;
	PageNavigation makePageNavigation(String pg, String key, String word) throws Exception;
	HouseVO getArticle(int articleNo) throws Exception;
}
