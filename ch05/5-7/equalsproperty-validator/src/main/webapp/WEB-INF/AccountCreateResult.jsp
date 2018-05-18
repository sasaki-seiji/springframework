<html>
<body>
<h2>登録完了画面</h2>
<table>
<tr>
	<td>名前:</td><td><c:out value="${accountCreateForm.name}"/></td>
</tr>
<tr>
	<td>パスワード:</td><td><c:out value="${accountCreateForm.password}"/></td>
</tr>
</table>
<ul>
	<li><a href="<c:url value='/' />">登録画面へ</a></li>
</ul>
</body>
</html>
