<html>
<body>
<h2>Accounts Menu</h2>
<a href="<c:url value='/'/>" >ルートメニューに戻る</a>
<c:url var="logoutUrl" value="/logout"/>
<form:form action="${logoutUrl}">
	<input type="submit" value="ログアウト(form:form)" />
</form:form>
</body>
</html>
