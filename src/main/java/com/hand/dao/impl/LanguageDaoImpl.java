package com.hand.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hand.dao.LanguageDao;
import com.hand.entity.Language;
import com.maheng.db.QueryRunner;

public class LanguageDaoImpl extends LanguageDao{

	@Override
	public Language getName(Byte id) {
		String sql = "select name from language where language_id = ?";
		Language language = null;
		try {
			language = QueryRunner.queryUnique(sql, Language.class, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return language;
	}

	@Override
	public List<Language> getAll() {
		String sql = "select * from language";
		List<Language> list = null;
		try {
			list = QueryRunner.query(sql, Language.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
