<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>24jz0145|村松怜加</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1>ユーザー登録</h1>

<c:choose>
<c:when test="${not empty msg}">
${msg}
</c:when>
</c:choose>

<form action="RegisterUser" method="post">
Email：<input type="text" name="email"><br>
パスワード：<input type="text" name="pass"><br>
名前：<input type="text" name="name"><br>
<input type="submit" value="確認">
</form>
</body>
</html>