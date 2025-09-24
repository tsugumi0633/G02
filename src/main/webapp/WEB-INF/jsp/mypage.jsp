<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>24jz0145 MyApp</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1>${loginUser.name}さんのマイページ</h1>
<a href="UranaiServlet">今日の運勢</a>
</body>
</html>