package com.maheng.utils;

public class StringUtils {
	
	public static String HungarianCaseToLowerCamelCase(String str){
		String[] split = str.split("_");
		str = "";
		for( int i = 0; i < split.length; i++){
			if( i >= 1 )
				split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length());
			str += split[i];
		}
		return str;
	}
	
	public static String HungarianCaseToUpperCamelCase(String str){
		String[] split = str.split("_");
		str = "";
		for( int i = 0; i < split.length; i++){
			split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length());
			str += split[i];
		}
		return str;
	}
}
