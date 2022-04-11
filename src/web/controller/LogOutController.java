package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.util.MyException;

public class LogOutController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MyException {
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		
	}

}
