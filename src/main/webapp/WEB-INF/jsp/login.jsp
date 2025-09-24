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
<h1>ログイン</h1><hr>
<form action="Login" method="post">
  <dl>
    <dt>Email</dt>
    <dd><input type="text" name="email" value=""></dd>

    <dt>パスワード</dt>
    <dd><input type="password" name="pass" value=""></dd>
  </dl>
  <input type="submit" value="ログイン"><br>
  
  <c:if test="${not empty error}">
  ${error}
</c:if>

</form>
</body>
</html>