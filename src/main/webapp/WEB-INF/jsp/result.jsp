<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    model.Fortune fortune = (Fortune) request.getAttribute("fortune");
    %>
    <%@ page import ="model.Fortune" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ占い</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1>スッキリ占い</h1>
<p>
<%= fortune.getName() %>さんの　<%= fortune.getToday() %>の運勢は<br>
        <%= fortune.getLuck() %>です
</p>
</body>
</html>