package com.hand.dao.impl;

import java.sql.Connection;
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
		Connection conn = DBUtils.openConn();
		List<Film> list = null;
		try {
			list = QueryRunner.query(conn, sql, Film.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
