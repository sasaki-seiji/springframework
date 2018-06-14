<html>
<body>
	<h2>spring:escapeBody tag</h2>
	<spring:escapeBody htmlEscape="true">${messageHtml}</spring:escapeBody>
	<script type="text/javascript">
		var message = "<spring:escapeBody javaScriptEscape='ture'>${messageJS}</spring:escapeBody>";
		alert(message);
		var message2 = "<spring:escapeBody htmlEscape='ture' javaScriptEscape='true'>${messageHtmlJS}</spring:escapeBody>";
	</script>
	<input type="submit" onclick="return confirm(message2)" />
</body>
</html>