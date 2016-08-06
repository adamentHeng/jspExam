package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.CustomerDao;
import com.maheng.db.DBUtils;

public class CustomerDaoImpl extends CustomerDao{
	
	public boolean existFirstName(String firstName){
		String sql = "select count(*) from customer where first_name = ?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = DBUtils.openConn();
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			resultSet = preparedStatement.executeQuery();
			if( resultSet.next() ){
				int count = resultSet.getInt(1);
				if( count > 0)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
