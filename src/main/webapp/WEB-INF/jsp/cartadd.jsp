<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>24jz0145 | カートに追加</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

<form action="CartAddServlet" method="post">
<table>
<tr>
<td> <img src="assets/img/${goods.image}" alt="${goods.goodsName}" width="100" height="100">
</td>

<td>
<table>
<tr>
 <td>商品コード</td>
 <td>${goods.goodsCode}
</tr>

<tr>
 <td>商品名</td>
 <td>${goods.goodsName}
</tr>

<tr>
 <td>商品単価</td>
 <td>${goods.price}
</tr>

<tr>
 <td>購入数量</td>
 <td>
  <select name="num">
   <c:forEach var="i" begin="1" end="${goods.stock}">
    <option value="${i}">${i}</option>
   </c:forEach>
  </select>
 </td>
</tr>

<tr>
 <td>
  <button type="submit">カートに追加</button>
  <input type="hidden" name="id" value="${goods.id }">
 </td>
</tr>

</td>
</tr>
</table>
</table>
</form>
</body>
</html>