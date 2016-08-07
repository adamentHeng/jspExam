package com.hand.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.entity.Language;
import com.hand.service.CustomerService;
import com.hand.service.FilmService;
import com.hand.service.LanguageService;

public class CustomerServlet extends HttpServlet{
	private CustomerService customerService = new CustomerService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		if( customerService.existFirstName(name)){
			req.getSession().setAttribute("name", name);
			LanguageService languageService = new LanguageService();
			List<Language> languageList = languageService.getAll();
			req.getSession().setAttribute("languageList", languageList);
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		}
		else{
			req.getSession().removeAttribute("name");
			resp.getWriter().print(new String("用户或密码错误"));
		}
	}
	
}
