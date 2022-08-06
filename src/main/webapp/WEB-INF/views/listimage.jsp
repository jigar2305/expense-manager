<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listimage</title>
</head>
<body>
<c:forEach items="${images}" var="i">
${i.userid}
<img alt="some thing went wrong" height="200" width="300" src="${i.url}">
</c:forEach>
</body>
</html>