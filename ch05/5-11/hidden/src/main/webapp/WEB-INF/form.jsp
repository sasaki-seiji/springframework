<html>
<body>
	<h2>hidden</h2>
	受付番号：${hiddenForm.acceptNo}<br />
	<form:form modelAttribute="hiddenForm">
		<form:hidden path="acceptNo" />
		<form:button>送信</form:button>
	</form:form>
</body>
</html>