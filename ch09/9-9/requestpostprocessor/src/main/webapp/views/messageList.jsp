<html>
<body>
<h2>message list</h2>
<ul>
	<c:forEach var="message" items="${messageList}">
		<li><c:out value="${message.id}"/>&nbsp;<c:out value="${message.message}"/></li>
	</c:forEach>
</ul>

<c:url var="messageAddUrl" value="/message/add"/>
<form:form modelAttribute="message" action="${messageAddUrl}">
	新しいメッセージ： <form:input path="message"/> <form:button name="add">追加</form:button>
</form:form>

<a href="<c:url value='/' />">ルートメニューへ</a>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
