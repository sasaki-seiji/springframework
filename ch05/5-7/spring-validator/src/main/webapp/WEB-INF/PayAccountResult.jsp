<html>
<body>
<h2>確認画面</h2>
<table>
<tr>
	<td>名前</td><td><c:out value="${accountCreateForm.name}"/></td>
</tr>
<tr>
	<td>タイプ</td><td>有料会員</td>
</tr>
<tr>
	<td>カード番号</td><td><c:out value="${accountCreateForm.cardNo}" /></td>
</tr>
</table>
<ul>
	<li><a href="<c:url value='/' />">アカウント作成画面へ</a></li>
</ul>
</body>
</html>
