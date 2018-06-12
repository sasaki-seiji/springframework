<html>
<body>
	<h2>spring:transform tag</h2>
	<form:form modelAttribute="transformForm" >
		<form:select path="departureDate" >
			<c:forEach items="${targetDateList}" var="targetDate">
				<spring:transform value="${targetDate}" var="formattedTargetDate"/>
				<form:option value="${formattedTargetDate}">
					${formattedTargetDate}
				</form:option>
			</c:forEach>
		</form:select>
		<form:button>送信</form:button>
	</form:form>
</body>
</html>