package com.hand.service;

import java.util.List;

import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.entity.Film;

public class FilmService {
	private FilmDao filmDao = new FilmDaoImpl();
	
	public List<Film> getAll(){
		return filmDao.getAll();
	}
}
