<html>
<body>
<spring:eval var="cart" expression="@cart" />

<h2>カートの内容</h2>
<table>
	<tr>
		<th>ID</th>
		<th>商品名</th>
		<th>単価</th>
		<th>個数</th>
		<th>価格</th>
		<th colspan="3">カートの操作</th>
	</tr>
<c:forEach var="content" items="${contents}">
	<spring:url value="/cart/{id}" var="target">
		<spring:param name="id" value="${content.item.id}"/>
	</spring:url>
	<form action="${target}" method="post">
	<tr>
		<td><c:out value="${content.item.id}"/></td>
		<td><c:out value="${content.item.name}"/></td>
		<td><c:out value="${content.item.prise}"/></td>
		<td><c:out value="${content.quantity}"/></td>
		<td><c:out value="${content.prise}"/></td>
		<td><button type="submit" name="increment">＋</button></td>
		<td><button type="submit" name="decrement">―</button></td>
		<td><button type="submit" name="clear">クリア</button></td>
	</tr> 
	</form>
</c:forEach>
	<tr>
		<td colspan="4">合計</td>
		<td><c:out value="${cart.totalPrise}"/></td>
	</tr>
	
</table>

<c:url value="/item" var="itempath" />
<a href="${itempath}">アイテム一覧に戻る</a>
<c:url value="/order" var="orderpath" />
<form action="${orderpath}" method="post">
	<button type="submit" name="order">注文</button>
</form>

</body>
</html>