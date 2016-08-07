package com.hand.dao;

import java.util.List;

import com.hand.entity.Film;

public abstract class FilmDao {
	public abstract List<Film> getAll();
	public abstract List<Film> queryPage(Integer page, Integer count);
	public abstract int remove(Short id);
	public abstract void save(Film film);
	public abstract Integer count();
}
