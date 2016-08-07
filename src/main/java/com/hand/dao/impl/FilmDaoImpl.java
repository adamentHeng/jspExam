package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hand.dao.FilmDao;
import com.hand.entity.Film;
import com.maheng.db.DBUtils;
import com.maheng.db.QueryRunner;

public class FilmDaoImpl extends FilmDao{

	@Override
	public List<Film> getAll() {
		String sql = "select film_id,title,description,language_id  from film ";
		List<Film> list = null;
		try {
			list = QueryRunner.query(sql, Film.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Film> queryPage(Integer page, Integer count) {
		if(page < 0 || count < 0) 
			throw new IllegalArgumentException("Illegal parameter of 'page' or 'count', Must be positive.");
		Integer from = (page - 1) * count;
		count = (count > 0) ? count : Integer.MAX_VALUE;
		String sql = "select film_id,title,description,language_id  from film limit ?,?";
		List<Film> list = null;
		try {
			list = QueryRunner.query(sql, Film.class, from, count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int remove(Short id) {
		String sql = "delete from film where film_id = ?";
		try {
			return QueryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void save(Film film) {
		String sql = "";
		if(film.getFilmId() != null ) {
			sql = "insert into film(film_id,title,description,language_id) values(null,?,?,?)";
			try {
				QueryRunner.update(sql, film.getTitle(), film.getDescription(), film.getLanguageId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			sql = "update film set title = ?, description = ?, language_id = ? where film_id = ?";
			try {
				QueryRunner.update(sql, film.getTitle(), film.getDescription(), film.getLanguageId(),film.getFilmId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from film";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = DBUtils.openConn();
		try {
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if( resultSet.next() ){
				int count = resultSet.getInt(1);
				return count;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
