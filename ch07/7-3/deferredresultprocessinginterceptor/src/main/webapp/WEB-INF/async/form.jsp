<html>
<body>
	<h2>DeferredResultProcessingInterceptor テスト</h2>
	<c:url value="/async" var="wait1sec" >
		<c:param name="waitSec" value="1"/>
	</c:url>
	<c:url value="/async" var="wait5sec" >
		<c:param name="waitSec" value="5"/>
	</c:url>
	<c:url value="/async" var="wait999sec" >
		<c:param name="waitSec" value="999"/>
	</c:url>
	<a href="${wait1sec}">1秒かかる</a><br />
	<a href="${wait5sec}">5秒かかる</a><br />
	<a href="${wait999sec}">999秒かかる(疑似エラー)</a><br />
	
</body>
</html>