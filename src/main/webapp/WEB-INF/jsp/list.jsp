<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>24JZ0145 | 商品一覧</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<p>検索キーワードを入力してください。</p>
<form action="ListServlet" method="post">
<input type="text" name="keyword"> <input type="submit" value="検索">
</form>

<hr>
  <table border="1">
 <c:choose>
 
 <c:when test="${not empty goodsList}">
        <tr>
        <th>商品コード</th>
        <th>商品名</th>
        <th>商品単価</th>
        <th>在庫数</th>
        <th>イメージ</th>
        <th></th> </tr>
                <c:forEach items="${goodsList}" var="item">
                    <tr>
                        <td>${item.goodsCode}</td>
                        <td>${item.goodsName}</td>
                        <td>${item.price} 円</td>
                        <td>${item.stock}</td>
                        <td>
                            <img src="assets/img/${item.image}" alt="${item.goodsName}" width="100" height="100">
                        </td>
                        <td>
                        <a href="CartAddServlet?id=${item.id}">
                        <button type="button">カートに追加</button>
                        </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
               <p>商品が見つかりませんでした。</p>
            </c:otherwise>
        </c:choose>
    </table>
</body>
</html>