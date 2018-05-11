<html>
<body>
	<h2>登録画面</h2>
	<form:form modelAttribute="accountCreateForm" action="create">
		<div>名前：</div>
		<div>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>電話番号:</div>
		<div>
			<form:input path="tel" />
			<form:errors path="tel" />
		</div>
		<div>誕生日:</div>
		<div>
			<form:input path="dateOfBirth" type="date" />
			<form:errors path="dateOfBirth" />
		</div>
		<div>メールアドレス：</div>
		<div>
			<form:input path="email" type="email"/>
			<form:errors path="email" />
		</div>
		<br />
		<div>
			<form:button name="cancel">中止</form:button>
			<form:button name="create">登録</form:button>
		</div>
	</form:form>
</body>
</html>