<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="createUser">
	<s:actionmessage />
	<s:actionerror />
	
	<s:textfield id="userName" name="userVO.userName" key="create.user.username" />
	<s:textfield id="name" name="userVO.name" key="create.user.name" />
	<s:textfield id="lastName" name="userVO.lastName" key="create.user.last.name" />
	
	<s:textfield id="email" name="userVO.email" key="create.user.email" />
	
	<s:password id="userPwd" name="userVO.userPwd" key="create.user.password" />
	<s:password id="userPwd" name="userVO.userPwdRepeat" key="create.user.password.repeat" />
	
	<s:select id="defaultLanguage" name="defaultLanguage" key="create.user.language" list="languages" listKey="language" listValue="displayName" />
	
	<s:checkboxlist id="choosenRols" name="choosenRoles" key="create.user.rols" list="rols" listKey="rolId" listValue="name" />
	
	<s:submit />
</s:form>