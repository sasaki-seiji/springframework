<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="tokenString" type="java.lang.String" required="true" %>

<c:forEach var="token" items="${tokenString}">
	<c:out value="${token}" /><br />
</c:forEach>