package com.maheng.db;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.maheng.utils.StringUtils;

public class QueryRunner {
	
	public static <T> T queryUnique(Connection conn, String sql, Class<T> beanClass ,Object... params) throws SQLException{
		if( conn == null ){
			throw new SQLException("Connection is null");
		}
		
		if( sql == null ){
			throw new SQLException("Sql statement is null");
		}
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		T result = null;
		
		preparedStatement = conn.prepareStatement(sql);
		for( int i = 0; i < params.length; i++ ){
			preparedStatement.setObject(i+1, params[i]);
		}
		resultSet = preparedStatement.executeQuery();
		if( resultSet.next() ){
			try {
				result = beanClass.newInstance();		
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			ResultSetMetaData metaData = resultSet.getMetaData();
			for( int i = 0; i < metaData.getColumnCount(); i++ ){
				String field = metaData.getColumnName(i+1);
				//System.out.println(field + " " + metaData.getColumnTypeName(i+1));
				try {
					String fieldName = StringUtils.HungarianCaseToUpperCamelCase(field);
					Class<?> typeClass = dbTypeToJavaType(metaData.getColumnTypeName(i+1));
					Method method = beanClass.getMethod("set" + fieldName, typeClass );
					Method resultSetMethod = ResultSet.class.getMethod("get"+ typeClass.getSimpleName(), int.class);
					method.invoke(result, resultSetMethod.invoke(resultSet, i+1));
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}		
		}
		return result;
	}
	
	public static <T> List<T> query(Connection conn, String sql, Class<T> beanClass ,Object... params) throws SQLException{
		if( conn == null ){
			throw new SQLException("Connection is null");
		}
		
		if( sql == null ){
			throw new SQLException("Sql statement is null");
		}
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		T result = null;
		List<T> list = new ArrayList<T>();
		
		preparedStatement = conn.prepareStatement(sql);
		for( int i = 0; i < params.length; i++ ){
			preparedStatement.setObject(i+1, params[i]);
		}
		resultSet = preparedStatement.executeQuery();
		while( resultSet.next() ){
			try {
				result = beanClass.newInstance();		
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			ResultSetMetaData metaData = resultSet.getMetaData();
			for( int i = 0; i < metaData.getColumnCount(); i++ ){
				String field = metaData.getColumnName(i+1);
				//System.out.println(field + " " + metaData.getColumnTypeName(i+1));
				try {
					String fieldName = StringUtils.HungarianCaseToUpperCamelCase(field);
					Class<?> typeClass = dbTypeToJavaType(metaData.getColumnTypeName(i+1));
					Method method = beanClass.getMethod("set" + fieldName, typeClass );
					Method resultSetMethod = ResultSet.class.getMethod("get"+ typeClass.getSimpleName(), int.class);
					method.invoke(result, resultSetMethod.invoke(resultSet, i+1));
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			list.add(result);
		}
		return list;
	}
	
	
	private static Class<?> dbTypeToJavaType(String type){
		type = type.toLowerCase();
		if (type.contains("tinyint")) {
			return Byte.class;
		} else if (type.contains("smallint")) {
			return Short.class;
		} else if (type.contains("bigint")) {
			return Long.class;
		} else if (type.contains("int")) {
			return Integer.class;
		} else if (type.contains("datetime") || type.contains("date") || type.contains("timestamp")) {
			return Date.class;
		}else if (type.contains("binary") || type.contains("blob")) {
			return byte[].class;
		} else {
			return String.class;
		}
	}
}
