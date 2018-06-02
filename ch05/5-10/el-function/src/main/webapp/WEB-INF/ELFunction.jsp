<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h2>EL function</h2>
<span id="message">${message}</span><br />
<span id="message">${fn:escapeXml(message)}</span><br />
