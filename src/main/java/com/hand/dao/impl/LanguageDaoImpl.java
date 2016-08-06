package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.dao.LanguageDao;
import com.hand.entity.Language;
import com.maheng.db.DBUtils;
import com.maheng.db.QueryRunner;

public class LanguageDaoImpl extends LanguageDao{

	@Override
	public Language getName(Byte id) {
		String sql = "select name from language where language_id = ?";
		Connection conn = DBUtils.openConn();
		Language language = null;
		try {
			language = QueryRunner.queryUnique(conn, sql, Language.class, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return language;
	}
	
}
