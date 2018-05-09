<html>
<body>
	<h2>登録確認画面</h2>
	<form:form modelAttribute="account" action="create">
		<div>ID:</div>
		<div>
			<form:input path="id" readonly="true" />
			<form:errors path="id" />
		</div>
		<div>名前：</div>
		<div>
			<form:input path="name" readonly="true" />
			<form:errors path="name" />
		</div>
		<div>email：</div>
		<div>
			<form:input path="email" readonly="true" />
			<form:errors path="email" />
		</div>
		<br />
		<form:button name="redo">戻る</form:button>
		<form:button name="create">登録</form:button>
	</form:form>
</body>
</html>