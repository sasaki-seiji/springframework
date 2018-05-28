<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  -->
<h2>Cusom Taglib</h2>
<c:forEach var="hobby" items="Sports,Movie,Music,スポーツ,映画,音楽" >
	<c:out value="${hobby}" /><br />
</c:forEach>