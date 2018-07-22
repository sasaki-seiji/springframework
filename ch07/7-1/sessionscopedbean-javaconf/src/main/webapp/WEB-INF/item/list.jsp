<html>
<body>
<h2>アイテム一覧</h2>

<table>
	<tr>
		<th>ID</th>
		<th>商品名</th>
		<th>価格</th>
		<th>カートに入れる</th>
	</tr>
<c:forEach var="item" items="${items}">
	<spring:url value="/cart/{id}" var="target">
		<spring:param name="id" value="${item.id}"/>
	</spring:url>
	<form action="${target}" method="post">
	<tr>
		<td><c:out value="${item.id}"/></td>
		<td><c:out value="${item.name}"/></td>
		<td><c:out value="${item.prise}"/></td>
		<td><button type="submit" name="increment">追加</button></td>
	</tr> 
	</form>
</c:forEach>
</table>
</body>
</html>