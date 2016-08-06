package com.hand.tag;

/**
 * 自定义函数标签
 * */
public class MyFunctionTag {

	/**
	 * 方法必须是静态的
	 * */
	public static String cap(String text) {
		String[] arr = text.split("\\s+");
		StringBuffer sb = new StringBuffer();
		for(String str : arr) {
			sb.append(str.substring(0, 1).toUpperCase() + str.substring(1));
			sb.append(" ");
		}
		if(sb.length() >= 1) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
	
}
