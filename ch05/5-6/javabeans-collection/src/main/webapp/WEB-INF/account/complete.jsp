<html>
<body>
<h2>登録完了画面</h2>

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

<h3>カード情報１</h3>
<table>
<tr>
	<td>番号:</td>
	<td><c:out value="${accountCreateForm.cards[0].no}"/></td>
</tr>
<tr>
	<td>期限:</td>
	<td><c:out value="${accountCreateForm.cards[0].validMonth}"/></td>
</tr>	
</table>

<h3>カード情報２</h3>
<table>
<tr>
	<td>番号:</td>
	<td><c:out value="${accountCreateForm.cards[1].no}"/></td>
</tr>
<tr>
	<td>期限:</td>
	<td><c:out value="${accountCreateForm.cards[1].validMonth}"/></td>
</tr>	
</table>

<ul>
	<li><a href="<c:url value='/' />">メニューへ</a></li>
</ul>
</body>
</html>
