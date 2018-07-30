<html>
<body>
	<h2>CallableProcessingInterceptor テスト</h2>
	<c:url value="/async" var="wait1sec" >
		<c:param name="waitSec" value="1"/>
	</c:url>
	<c:url value="/async" var="wait5sec" >
		<c:param name="waitSec" value="5"/>
	</c:url>
	<a href="${wait1sec}">1秒かかる</a><br />
	<a href="${wait5sec}">5秒かかる</a><br />
	
</body>
</html>