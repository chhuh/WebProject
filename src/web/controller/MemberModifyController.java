package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import web.dao.MemberDAO;
import web.dao.MemberDAOImpl;
import web.util.MyException;
import web.vo.MemberVO;

public class MemberModifyController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,  MyException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		String fl=request.getParameter("fl");
		
		MemberVO memberVO=new MemberVO(0,name,email,pw, fl);
		System.out.println(memberVO);
		
		MemberDAO memberDAO = MemberDAOImpl.getInstance();
		memberDAO.memberUpdate(memberVO);
		
		
	}

}
