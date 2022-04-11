package web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.NoticeDAO;
import web.dao.NoticeDAOImpl;
import web.util.MyException;
import web.vo.NoticeVO;

public class NoticeRefreshController implements Controller {

//	private static NoticeRefreshController instance;
//	private NoticeRefreshController() {}
//	public static NoticeRefreshController getInstance() {
//		if(instance==null) {
//			instance = new NoticeRefreshController();
//		}
//		return instance;
//	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MyException {
		NoticeDAO noticeDAO = NoticeDAOImpl.getInstance();
		ArrayList<NoticeVO> list = noticeDAO.getNoticeList();
		ServletContext application = request.getServletContext();
		application.setAttribute("noticeList",list);
	}}
