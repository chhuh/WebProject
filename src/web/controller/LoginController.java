package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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

public class LoginController implements Controller{

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
		
		String email=request.getParameter("id");
		String pw=request.getParameter("pwd");
		MemberVO memberVO=new MemberVO(email,pw);
		System.out.println(memberVO);
		
		MemberDAO memberDAO = MemberDAOImpl.getInstance();
		memberVO = memberDAO.login(memberVO);
		JSONObject jo = new JSONObject();
		if(memberVO!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("memberVO", memberVO);
			
//			if(memberVO.getUserType().equals("guest")) {
//				HouseService houseService=HouseService.getInstance();
//				ArrayList<HouseDeal> list=houseService.getHouseDealList();
//				session.setAttribute("houseList", list);
//			}
			
			jo.put("name", memberVO.getName());
		}else {
			jo.put("msg","다시 로그인 해주세요");
		}
		out.append(jo.toString());
	}

}
