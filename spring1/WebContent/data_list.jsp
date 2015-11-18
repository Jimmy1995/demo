<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="plusController!selOne_detail" method="post">
		<table border="15" cellpadding="0" cellspacing="0">
			<tr>
				<td>学生编号</td>
				<td>学生姓名</td>
			</tr>
			<c:forEach items="${list}" var="stu">
				<tr>
					<td>${stu.id}</td>
					<td>${stu.name}</td>
				</tr>
			</c:forEach>
		</table>
	</form><br><br>
	<hr align="left" color="lightgreen" size="3"/>
	<a href="/spring1/add.jsp">新增学生</a>
</body>
</html>