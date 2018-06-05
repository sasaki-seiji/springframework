<html>
<body>
	<h2>form:checkbox</h2>
	<form:form modelAttribute="checkboxForm">
		利用規約：<form:checkbox path="agreement" label="同意する" /><br />
		<form:button>送信</form:button>
	</form:form>
</body>
</html>