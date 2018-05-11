<html>
<body>
<h2>アカウント詳細</h2>
<p>名前: <c:out value="${accountCreateForm.name}"/></p>
<p>電話番号: <c:out value="${accountCreateForm.tel}"/></p>
<p>誕生日: <c:out value="${accountCreateForm.dateOfBirth}"/></p>
<p>メールアドレス: <c:out value="${accountCreateForm.email}"/></p>
<ul>
	<li><a href="<c:url value='/' />">メニューへ</a></li>
</ul>
</body>
</html>