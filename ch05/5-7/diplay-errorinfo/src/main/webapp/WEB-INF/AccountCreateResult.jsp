<html>
<body>
<h2>確認画面</h2>
<table>
<tr>
	<td>名前:</td>
	<td><c:out value="${accountCreateForm.name}"/></td>
</tr>
<tr>
	<td>誕生日</td>
	<td><c:out value="${accountCreateForm.dateOfBirth}"/></td>
</tr>
<tr>
	<td>住所</td>
	<td><c:out value="${accountCreateForm.streetAddress}" /></td>
	<td><form:errors path="streetAddress" /></td>
</tr>
</table>
<ul>
	<li><a href="<c:url value='/' />">アカウント作成画面へ</a></li>
</ul>
</body>
</html>
