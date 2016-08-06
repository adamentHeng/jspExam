package com.hand.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeloUI extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		String html = "<!DOCTYPE html><html>";
			  	html += "<head>";
			  	html += "	<title>hello页面</title>";
			  	html += "	<meta http-equiv=\"content-type\" content=\"charset=UTF-8\">";
			  	html += "</head>";
			  	html += "<body>";
			  	html += "	<h1>Hello World!</h1>";
			  	html += new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			  	html += "</body>";
			  	html += "</html>";
		
		resp.getWriter().println(html);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
	}

		
}
