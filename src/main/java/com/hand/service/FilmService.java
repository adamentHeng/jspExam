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
	
	public int remove(Short id){
		return filmDao.remove(id);
	}
	
	public void save(Film film){
		filmDao.save(film);
	}
	
	public List<Film> queryPage(Integer page, Integer count){
		return filmDao.queryPage(page, count);
	}
	
	public Integer count(){
		return filmDao.count();
	}
}
