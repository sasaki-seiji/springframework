<html>
<body>
<spring:eval var="cart" expression="@cart" />

<h2>注文完了</h2>

購入商品数:　<c:out value="${totalQuantity}"/><br />
合計金額:　<c:out value="${totalPrise}"/><br />

<c:url value="/item" var="itempath" />
<a href="${itempath}">アイテム一覧に戻る</a>

</body>
</html>