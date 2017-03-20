<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<tiles:insertAttribute name="header" />
	</head>
	<body>
		<div id="top">
			<tiles:insertAttribute name="top" />
		</div>
		
		<s:if test="#session.loginId != null">
			<div id="menu">
				<tiles:insertAttribute name="menu" />
			</div>
		</s:if>
		
		<div id="body">
			<tiles:insertAttribute name="body" />
		</div>
		
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>