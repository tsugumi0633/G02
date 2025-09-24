<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>23jz0145 | カート</title>
</head>
<body>
<jsp:include page="menu.jsp"/>

<c:if test="${cartList.size() > 0}">
<p>${cartList.size()}種類の商品があります</p>
</c:if>
<c:if test="${empty cartList}">
<p>カートに商品がありません</p>
</c:if>
<hr>
<c:if test="${not empty cartList}" >
 <c:forEach var="cartItem" items="${cartList}">
<table border="1">
  <tr>
   <td>${cartItem.goods.goodsName}</td>
   <td>${cartItem.goods.price}円</td>
   <td><img src="assets/img/${cartItem.goods.image}" alt="${cartItem.goods.goodsName}" width="100" height="100">
   <td>
   <a href="CartDeleteServlet?id=${cartItem.goods.id}">
   <button type="button">カートから削除</button></a>
   </td>
  </tr>
  </table>
 </c:forEach>
</c:if>
</body>
</html>