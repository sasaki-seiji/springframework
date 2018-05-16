<html>
<body>
<h2>検索結果</h2>

<h3>アカウント情報</h3>
<table>
<tr>
	<td>名前:</td>
	<td><c:out value="${accountCreateForm.account.name}"/></td>
</tr>
<tr>
	<td>メールアドレス:</td>
	<td><c:out value="${accountCreateForm.account.email}"/></td>
</tr>
</table>

<h3>カード情報</h3>
<table>
<tr>
	<td>番号:</td>
	<td><c:out value="${accountCreateForm.card.no}"/></td>
</tr>
<tr>
	<td>期限:</td>
	<td><c:out value="${accountCreateForm.card.validMonth}"/></td>
</tr>
</table>

<ul>
	<li><a href="<c:url value='/' />">メニューへ</a></li>
</ul>
</body>
</html>