<html>
<body>
	<h2>form:radiobutton</h2>
	<form:form modelAttribute="radiobuttonForm">
		性別：<form:radiobutton path="gender" value="mem" label ="男性" />
			<form:radiobutton path="gender" value="womem" label ="女性" /><br />
		<form:button>送信</form:button>
	</form:form>
</body>
</html>