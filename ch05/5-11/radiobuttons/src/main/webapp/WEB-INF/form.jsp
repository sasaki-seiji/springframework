<spring:eval expression="@genderCodeList" var="genderCodeList" />

<html>
<body>
	<h2>form:radiobuttons</h2>
	<form:form modelAttribute="radiobuttonsForm">
		性別：<form:radiobuttons path="gender" items="${genderCodeList}" /><br />
		<form:button>送信</form:button>
	</form:form>
</body>
</html>