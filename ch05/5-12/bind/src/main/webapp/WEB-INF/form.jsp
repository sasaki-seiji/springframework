<html>
<body>
	<h2>spring:bind tag</h2>
	<form:form modelAttribute="accountCreateForm" >
		ユーザー名：<form:input path="username" /><br />
		生年月日(yyyy/MM/dd)：<form:input path="dateOfBirth" /><br />
		<form:button>登録</form:button>
	</form:form>
	<spring:nestedPath path="accountCreateForm">
		<spring:bind path="username">
			${status.displayValue}<br />
		</spring:bind>
		<spring:bind path="dateOfBirth">
			${status.displayValue}<br />
		</spring:bind>
	</spring:nestedPath>
</body>
</html>