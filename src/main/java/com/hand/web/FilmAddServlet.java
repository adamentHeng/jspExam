package com.hand.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.service.FilmService;

/**
 * Servlet implementation class FilmAddServlet
 */
public class FilmAddServlet extends HttpServlet {
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
		String filmId = request.getParameter("filmId");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Byte languageId = Byte.parseByte(request.getParameter("languageId"));
		Film film = new Film();
		if( filmId != null )
		film.setFilmId(Short.parseShort(filmId));
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguageId(languageId);
		FilmService filmService = new FilmService();
		filmService.save(film);
		response.sendRedirect(request.getContextPath() + "/FilmShowServlet");
	}

}
