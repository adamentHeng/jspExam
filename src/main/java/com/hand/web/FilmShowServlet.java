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
import com.hand.service.FilmService;
import com.hand.service.LanguageService;

/**
 * Servlet implementation class FilmShowServlet
 */
public class FilmShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmService filmService = new FilmService();
		LanguageService languageService = new LanguageService();
		List<List<Object>> result = new ArrayList<List<Object>>();
		String pageStr = request.getParameter("page");
		String countStr = request.getParameter("count");
		Integer page = 1;
		Integer count = 10;
		System.out.println(countStr);
		try{
			page = pageStr == null || pageStr == "" ? 1 : Integer.parseInt(pageStr.contains(".")?pageStr.split(".")[0]:pageStr);
		} catch(Exception e){
		}
		try{
			count = countStr == null || countStr == "" ? 10 : Integer.parseInt(countStr);
		} catch(Exception e){
		}
		if( page <= 0 ) page = 1;
		int number = filmService.count();
		if( page > number ) page = number;
		if( count <= 0 ) count = 10;
		if( count > number ) count = number;
		List<Film> list = filmService.queryPage(page, count);
		for( Film film : list ){
			List<Object> row = new ArrayList<Object>(4);
			row.add(film);
			Language language = languageService.getName(film.getLanguageId());
			row.add(language);
			result.add(row);
		}
		request.setAttribute("filmList", result);
		
		int total = 0;
		if( number % count == 0  )
			total = number / count;
		else
			total = number / count + 1;
		request.setAttribute("total", total);
		request.setAttribute("page", page);
		System.out.println(count);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/showFilm.jsp").forward(request, response);
	}

}
