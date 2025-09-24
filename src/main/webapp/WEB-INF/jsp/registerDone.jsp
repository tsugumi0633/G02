<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>24jz0145|村松怜加</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1>ユーザー登録</h1>
<c:if test="${empty registerUser}">
<p>登録完了しました</p>
</c:if>
<c:if test="${not empty registerUser}">
<p>登録できませんでした</p>
<c:remove scope="session" var="registerUser"/>
</c:if>
<a href="RegisterUser">戻る</a>
</body>
</html>