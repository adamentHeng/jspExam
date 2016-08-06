<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<table>
		<thead>
			<tr>
				<td style="margin:10px;">film_id</td>
				<td style="margin:10px;">title</td>
				<td style="margin:10px;">description</td>
				<td style="margin:10px;">language</td>
			</tr>
		</thead>
		<tbody>
		<% List<List<Object>> result = (List<List<Object>>)request.getAttribute("filmList");
		   for( List<Object> list : result ){ 
		   request.setAttribute("list", list);%>
		   <tr>
			<c:forEach items="${list}" var="name" varStatus="idx">
				<td> ${name}</td>
	  		</c:forEach>
	  		</tr>
		  <% }	
		%>
		</tbody>
		<
	</table>
</center>
</body>
</html>