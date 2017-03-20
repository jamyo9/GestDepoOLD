<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1><s:text name="application.name" /></h1>

<s:if test="#session.loginId != null">
	<s:actionmessage />
	<s:actionerror/>
	<s:a action="logOut" ><s:text name="logout" /></s:a>
	
</s:if>
<s:else>
	
	<s:form action="loginUser">
		<s:actionmessage />
		<s:actionerror />
		
		<s:textfield id="userName" name="userVO.userName" key="login.user.name" />
		<s:password id="userPwd" name="userVO.userPwd" key="login.user.password" />
		<s:submit />
	</s:form>
	
	<s:a action="preCreateUser" id="preCreateUserLink"><s:text name="login.create.user" /></s:a>
	
</s:else>