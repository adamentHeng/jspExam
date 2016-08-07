<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电影租赁系统</title>
</head>
<body>
	<center>
	<h1>修改电影信息</h1>
	<form action="FilmAddServlet" method="post">
		<table>
			<tr hidden="true">
				<td>filmId</td>
				<td><input type="text"  name="filmId" value="${filmId}"/></td>
			</tr>
			<tr>
				<td>title</td>
				<td><input type="text"  name="title" value="${title}"/></td>
			</tr>
			<tr>
				<td>description</td>
				<td>
					<textarea rows="10" name="description" >
						${description}
					</textarea>
				</td>
			</tr>
			<tr>
				<td>language</td>
				<td>
					<select name="languageId">
						<#list languageList as language >
							<option value="${language.languageId}"
								<#if language.languageId == languageId>
									selected
								</#if>
							>${language.name}</option>
						</#list>
					</select>
				</td>			
			</tr>
			<tr>
				<td><input type="submit" value="保存"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="index.jsp">返回主页</a>
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>