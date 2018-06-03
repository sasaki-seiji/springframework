<html>
<body>
	<h2>Login Form</h2>
	<form:form modelAttribute="loginForm">
		ユーザー名：<form:input path="username" /><br />
		パスワード：<form:password path="password" /><br />
		<form:button>ログイン</form:button>
	</form:form>
</body>
</html>