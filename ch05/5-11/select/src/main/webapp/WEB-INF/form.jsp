<spring:eval expression="@prefectureCodeList" var="prefectureCodeList" />

<html>
<body>
	<h2>form:select</h2>
	<form:form modelAttribute="selectForm">
		お住まい：<form:select path="livingPrefecture" items="${prefectureCodeList}" /><br />
		<form:button>送信</form:button>
	</form:form>
</body>
</html>