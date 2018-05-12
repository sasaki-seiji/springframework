<html>
<body>
<h2>登録完了画面</h2>
<table>
<tr>
	<td>名前:</td><td><c:out value="${accountCreateForm.name}"/></td>
</tr>
<tr>
	<td>電話番号:</td><td><c:out value="${accountCreateForm.tel}"/></td>
</tr>
<tr>
	<td>誕生日:</td><td><c:out value="${accountCreateForm.dateOfBirth}"/></td>
</tr>
<tr>
	<td>メールアドレス:</td><td><c:out value="${accountCreateForm.email}"/></td>
</tr>
</table>
<ul>
	<li><a href="<c:url value='/' />">メニューへ</a></li>
</ul>
</body>
</html>
