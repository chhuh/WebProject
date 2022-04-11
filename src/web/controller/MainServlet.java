package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.*; //JAXP
import javax.xml.stream.events.StartElement;

import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import web.dao.MemberDAO;
import web.dao.NoticeDAO;
import web.util.MyException;
import web.vo.MemberVO;
import web.vo.NoticeVO;

public class MainServlet extends HttpServlet {
	
	HashMap<String, Controller> map;
	Controller ctrl;

	public void init() throws ServletException {
		ServletContext application = getServletContext();
		
		map = (HashMap<String,Controller>) application.getAttribute("map");
		if(map==null) {
			map = new HashMap<>();
			application.setAttribute("map", map);
		}
		try {
			SAXParserFactory f = SAXParserFactory.newInstance();
			SAXParser parser = f.newSAXParser();
			parser.parse("C:\\SSAFY\\FrontEnd\\0323_HappyHouse_SPA_Scope\\action-servlet.xml", new DefaultHandler() {
				
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					try {
						if(qName.equals("bean")) {
							String id = attributes.getValue("id");
							String clazz = attributes.getValue("class");
							
							Class clazz2 = Class.forName(clazz);
							Controller value = (Controller)clazz2.newInstance();
							map.put(id,value);
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(map);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		 String sign=request.getParameter("sign");
		 if(sign!=null) {
			 
			 try {
				 map.get(sign).execute(request,response);
			}catch(MyException e) {
				JSONObject jo = new JSONObject();
				 jo.put("msg",e.getMessage());
				 out.append(jo.toString());
			 }
			 
		 }else {
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		 }
		 
	}

}
