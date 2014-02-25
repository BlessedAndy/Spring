<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 此时没有写action,直接提交会提交给/add -->
<form:form method="post" modelAttribute="user" enctype="multipart/form-data">
	Username:<form:input path="username"/><form:errors path="username"/><br/>
	Password:<form:password path="password"/><form:errors path="password"/><br/>
	Nickname:<form:input path="nickname"/><br/>
	Email:<form:input path="email"/><form:errors path="email"/><br/>
	Attach:<input type="file" name="attachs"/><br/>	<input type="file" name="attachs"/><br/>	<input type="file" name="attachs"/><br/>	
	<input type="submit" value="添加用户"/>
</form:form>
</body>
</html>