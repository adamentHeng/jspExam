package com.hand.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.service.FilmService;

/**
 * Servlet implementation class FilmRemoveServlet
 */
public class FilmRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmService filmService = new FilmService();
		String id = request.getParameter("filmId");
		if( filmService.remove(Short.parseShort(id)) > 0)
			response.sendRedirect(request.getContextPath() + "/FilmShowServlet");
		else{
			response.getWriter().println("<html>存在外键关联！");
			response.getWriter().println("<a href='FilmShowServlet'>返回</a></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
