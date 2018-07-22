<html>
<body>
<spring:eval var="cart" expression="@cart" />

<h2>注文確認</h2>

<table>
	<tr>
		<th>ID</th>
		<th>商品名</th>
		<th>単価</th>
		<th>個数</th>
		<th>価格</th>
	</tr>
<c:forEach var="content" items="${contents}">
	<spring:url value="/cart/{id}" var="target">
		<spring:param name="id" value="${content.item.id}"/>
	</spring:url>
	<tr>
		<td><c:out value="${content.item.id}"/></td>
		<td><c:out value="${content.item.name}"/></td>
		<td><c:out value="${content.item.prise}"/></td>
		<td><c:out value="${content.quantity}"/></td>
		<td><c:out value="${content.prise}"/></td>
	</tr> 
</c:forEach>
	<tr>
		<td colspan="4">合計</td>
		<td><c:out value="${cart.totalPrise}"/></td>
	</tr>
	
</table>

<form method="get">
	<button type="submit" name="complete">完了</button>
	<button type="submit" name="editCart">注文の修正</button>
</form>

</body>
</html>