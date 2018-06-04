<spring:eval expression="@hobbyCodeList" var="hobbyCodeList" />

<html>
<body>
	<h2>form:checkboxes</h2>
	<form:form modelAttribute="checkboxesForm">
		趣味：<form:checkboxes path="hobbies" items="${hobbyCodeList}" /><br />
		<form:button>送信</form:button>
	</form:form>
</body>
</html>