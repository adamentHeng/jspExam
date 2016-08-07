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
<title>电影租赁系统</title>
<style>
		td, th {
			border: 1px solid black;
		}
		table {
			border-collapse: collapse;
			text-align: center;
		}
		caption {
			font-size: 25px;
		}
</style>
</head>
<body>
<center>
	<table width="80%">
		<caption>电影列表</caption>
		<thead>
			<tr>
				<th>film_id</th>
				<th>title</th>
				<th>description</th>
				<th>language</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${filmList}" var="list"  varStatus="idx">
		   <tr>
				<td> ${list[0].filmId}</td>
				<td> ${list[0].title}</td>
				<td> ${list[0].description}</td>
				<td> ${list[1].name}</td>
	  		<td>
	  			<a href="/FilmRemoveServlet?filmId=${list[0].filmId}">删除</a>
	  			<a href="/FilmUpdateServlet?filmId=${list[0].filmId}&title=${list[0].title}
	  			&description=${list[0].description}&languageId=${list[0].languageId}">编辑</a>
	  		</td>
	  		</tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<form action="FilmShowServlet" >
						<select name="count">
							<option value="10" 
							<% Integer count = (Integer)request.getAttribute("count"); 
							if(count == 10){%>
								selected <%}%>>10</option>
							<option value="20" 
							<% if(count == 20){
							%>
								selected <%}%>>20</option>
							<option value="50" 
							<% if(count == 50){%>
								selected <%}%>>50</option>
						</select>
						<a href="FilmShowServlet?page=1&count=${count}">首页</a>
						<a href="FilmShowServlet?page=${page-1 > 0 ? page - 1 : 1}&count=${count}">上一页</a>
						第
						<input name="page" style="width:20px;" value="${page}"/>
						共${total}页
						<a href="FilmShowServlet?page=${page+1 > total ? total : page + 1}&count=${count}">下一页</a>
						<a href="FilmShowServlet?page=${total}&count=${count}">尾页</a>
						<input type="submit" value="刷新"/>
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
	
</center>
</body>
</html>