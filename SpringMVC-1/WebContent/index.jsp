<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="helloworld">test HelloWorld-->hello</a><br/><br/><hr>
	
	<a href="springmvc/testRequestMapping">TEST testRequestMapping</a><br/><br/><hr>
	
	<a href="springmvc/testMethod">TEST testMethod--GET</a><br/><br/><hr> 
	
	<form action="springmvc/testMethod" method="post">
		<input type='submit' value='test testMethod--POST'>
	</form><br><br> 
	
	<a href="springmvc/testParamsAndMethods?username=admin&age=18">TEST testParamsAndMethods</a>
	<br/><br/><hr>
	
	<a href="springmvc/testAntPath/xyz123456/abc">TEST testAntPath</a>
	<br/><br/><hr>
	
	<a href="springmvc/testPathVariable/23">TEST testPathVariable</a>
	<br/><br/><hr color="green">
	
	
	
	<br/><br/>
	<a href="springmvc/testRest/1">TEST testRest GET</a>
	<br/><br/>
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="TEST testRest POST">
	</form>
	<br/><br/>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="TEST testRest DELETE">
	</form>
	<br/><br/>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="TEST testRest PUT">
	</form>
	<br><br><hr color="blue">
	
	
	<a href="springmvc/testRequestParam?username=admin&age=23">TEST testRequestParam</a>
	<br/><br/><hr>
	
	<a href="springmvc/testRequestHeader">TEST testRequestHeader</a>
	<br/><br/><hr>
	
	<a href="springmvc/testCookieValue">TEST testCookieValue</a>
	<br/><br/><hr color="brown"><br/>
	
	<form action="springmvc/testPojo" method="post">
		userName:<input name="userName"><br>
		password:<input type="password" name="password"><br>
		email:<input name="email"><br>
		age:<input name="age"><br>
		级联属性：<br>
		city:<input name="address.city"><br>
		province:<input name="address.province"><br>
		<input type="submit" value="Submit">		
	</form><br><br><br><br><br><hr color="brown"><br><br>
	
	<a href="springmvc/testServletAPI">TEST testServletAPI</a><br><br><hr>
	
	<a href="springmvc/testModelAndView">TEST testModelAndView</a><br><br>
	
	<a href="springmvc/testMap">TEST testaMap</a><br><br>
	
	<a href="springmvc/testSessionAttribute">TEST testSessionAttribute</a><br><br>
	
	<!-- 
		模拟修改操作 
		1.原始数据 	1，Jimmy,123,123456@qq.com,23
		2.密码不能被修改
		3.表单回显，模拟操作直接在表单填写对应的属性值
	 -->
	 <form action="springmvc/testModelAttribute" method="post">
	 	<input type="hidden" name="id" value="1"><br>
	 	userName: <input name="userName" value="Jimmy"><br>
	 	email: <input name="email" value="123456@qq.com"><br>
	 	age: <input name="age" value="23"><br>
	 	<input type="submit" value="Submit"><br>
	 	
	 </form>
	 
	
</body>
</html>