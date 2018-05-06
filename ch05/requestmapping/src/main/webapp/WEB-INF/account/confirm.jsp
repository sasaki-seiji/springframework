<html>
<body>
	<h2>登録確認画面</h2>
	<form:form modelAttribute="account" action="create">
		<p>ID: ${account.id}</p>
		<p>名前： ${account.name}</p>
		<p>email： ${account.email}</p>
		<br />
		<form:button name="redo">戻る</form:button>
		<form:button name="create">登録</form:button>
	</form:form>
</body>
</html>