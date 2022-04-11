package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import web.dao.MemberDAO;
import web.dao.MemberDAOImpl;
//import web.service.HouseService;
//import web.vo.HouseDeal;
import web.util.MyException;

import web.vo.MemberVO;

public class MemberDeleteController implements Controller{

//	private static LoginController instance;
//	private LoginController() {}
//	public static LoginController getInstance() {
//		if(instance==null) {
//			instance = new LoginController();
//		}
//		return instance;
//	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MyException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		MemberDAO memberDAO = MemberDAOImpl.getInstance();
		
		memberDAO.deleteMember(name);
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		
	}

}
