<html>
<body>
	<h2>spring:eval tag</h2>
	<spring:message code="guidance.passwordValidPolicy">
		<spring:argument>
			<spring:eval expression="@appSettings.passwordValidDays"/>
		</spring:argument>
	</spring:message><br />
</body>
</html>