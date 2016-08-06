package com.hand.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
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
			FilmService filmService = new FilmService();
			LanguageService languageService = new LanguageService();
			List<List<Object>> result = new ArrayList<List<Object>>();
			List<Film> list = filmService.getAll();
			for( Film film : list ){
				List<Object> row = new ArrayList<Object>(4);
				row.add(film.getFilmId());
				row.add(film.getTitle());
				row.add(film.getDescription());
				String languageName = languageService.getName(film.getLanguageId()).getName();
				row.add(languageName);
				result.add(row);
			}
			req.setAttribute("filmList", result);
			req.getRequestDispatcher("/showFilm.jsp").forward(req, resp);
		}
		else{
			req.getSession().removeAttribute("name");
			resp.getWriter().print(new String("用户或密码错误"));
		}
	}
	
}
