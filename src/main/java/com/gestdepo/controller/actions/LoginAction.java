package com.gestdepo.controller.actions;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.I18nInterceptor;
import org.apache.struts2.interceptor.SessionAware;

import com.gestdepo.model.exception.NoUserException;
import com.gestdepo.model.service.AccountService;
import com.gestdepo.model.vo.UserVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private UserVO userVO;
	
	private Map<String, Object> session;
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	private AccountService accountService;
	
	public String home() {
		return SUCCESS;
	}
	
	// Log Out user
	public String logOut() {
		session.remove("loginId");
		addActionMessage(getText("logout.success"));
		return SUCCESS;
	}
	
	// Login user
	public String login() {
		try {
			userVO = accountService.loginUser(userVO);
			
			Locale locale = userVO.getLocale();
			ActionContext.getContext().setLocale(locale);
			session.put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
			
			session.put("loginId", userVO.getUserId());
		} catch (NoUserException nue) {
			addActionError(getText("login.error"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}