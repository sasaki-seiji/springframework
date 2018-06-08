<html>
<body>
	<h2>form:checkbox</h2>
	<form:form modelAttribute="errorsForm">
		利用規約：<form:checkbox path="agreement" label="同意する" />
		<form:errors path="agreement" /><br />
		<form:button>送信</form:button>
	</form:form>
</body>
</html>