<html>
<body>
	<h2>spring:message tag</h2>
	<spring:message code="title.home" /><br />
	<spring:message code="guidance.passwordValidPolicy" arguments="90" /><br />
	<spring:message code="guidance.passwordValidPolicy">
		<spring:argument value="100" />
	</spring:message><br />
</body>
</html>