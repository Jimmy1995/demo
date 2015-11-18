<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增学生</title>
</head>
<body>
	<form action="plusController?action=insertStudent" method="post">
		<table border="15" cellpadding="0" cellspacing="0">
			<tr>
				<td>学生编号:</td>
				<td><input name="id"/></td>
			</tr>
			<tr>
				<td>学生姓名:</td>
				<td><input name="name"/></td>
			</tr>
			<tr>
				<td><br></td>
				<td><input type="submit" value="新增"/></td>
			</tr>
		</table>
	</form><br><br><a href="javascript:history.back();">返回</a>
</body>
</html>