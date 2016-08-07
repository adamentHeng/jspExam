package com.hand.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.entity.Language;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class FilmUpdateServlet
 */
public class FilmUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filmId = request.getParameter("filmId");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String languageId = request.getParameter("languageId");
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(request.getSession().getServletContext().getRealPath("/WEB-INF")));
		//cfg.setServletContextForTemplateLoading(getServletContext(),"/WEB-INF");
		Map<String, Object> root = new HashMap<String, Object>(1);
		root.put("filmId", filmId);
		root.put("title", title);
		root.put("description", description);
		root.put("languageId", Byte.parseByte(languageId));
		List<Language> languageList = (List<Language>) request.getSession().getAttribute("languageList");
		root.put("languageList", languageList);
		Template t = cfg.getTemplate("editFilm.ftl");
		Writer out = new FileWriter(request.getSession().getServletContext().getRealPath("")+"/editFilm.html");
		try {
			t.process(root, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
		cfg.clearTemplateCache();
		response.setHeader("Pragma","No-cache"); 
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0); 
		response.sendRedirect(request.getContextPath() + "editFilm.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
