package com.hand.dao;

import java.util.List;

import com.hand.entity.Film;

public abstract class FilmDao {
	public abstract List<Film> getAll();
}
