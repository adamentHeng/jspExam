<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影租赁系统</title>
</head>
<body>
	<center>
	<h1>新增电影</h1>
	<form action="FilmAddServlet" method="post">
		<table>
			<tr>
				<td>title</td>
				<td><input type="text"  name="title" /></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="description"/></td>
			</tr>
			<tr>
				<td>language</td>
				<td>
					<select name="languageId">
						<c:forEach items="${languageList}" var="name" varStatus="idx">
							<option value="${name.languageId }">${name.name }</option>
		  				</c:forEach>	
					</select>
				</td>			
			</tr>
			<tr>
				<td><input type="submit" value="保存"/></td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>