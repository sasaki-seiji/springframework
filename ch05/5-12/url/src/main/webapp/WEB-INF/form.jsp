<html>
<body>
	<h2>spring:url tag</h2>
	<spring:url value="/users/{userId}" var="userUrl" >
		<spring:param name="userId" value="${userId}"/>
	</spring:url>
	<a href="${userUrl}"><c:out value="${userId}"/></a>
</body>
</html>