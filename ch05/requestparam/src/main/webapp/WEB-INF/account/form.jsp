<html>
<body>
	<h2>登録画面</h2>
	<form:form modelAttribute="account" action="create">
		<div>ID:</div>
		<div>
			<form:input path="id" />
			<form:errors path="id" />
		</div>
		<div>名前：</div>
		<div>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>email：</div>
		<div>
			<form:input path="email" />
			<form:errors path="email" />
		</div>
		<div>
			<form:button name="cancel">中止</form:button>
			<form:button name="confirm">確認</form:button>
		</div>
	</form:form>
</body>
</html>