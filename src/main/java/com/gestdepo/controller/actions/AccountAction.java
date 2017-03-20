package com.gestdepo.controller.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.I18nInterceptor;
import org.apache.struts2.interceptor.SessionAware;

import com.gestdepo.model.service.AccountService;
import com.gestdepo.model.service.LanguageService;
import com.gestdepo.model.vo.Rol;
import com.gestdepo.model.vo.UserVO;
import com.gestdepo.utils.AccountUtils;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private UserVO userVO;
	
	private List<Rol> rols = new ArrayList<Rol>();
	private String choosenRoles;
	private List<Locale> languages;
	private String defaultLanguage;
	
	private Map<String, Object> session;
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	private AccountService accountService;
	private LanguageService languageService;

	public String preCreateUser() {
		Locale locale = (Locale)session.get(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE);
		
		this.setLanguages(languageService.getPossibleLanguages(locale));
		this.setRols(accountService.getPossibleRols(locale));
		this.setUserVO(new UserVO());
		
		return SUCCESS;
	}

	public String createUser() {
		
		userVO.setRols(AccountUtils.transformRols(choosenRoles, defaultLanguage));
		userVO.setLocale(new Locale(defaultLanguage));
		
		try {
			userVO = accountService.createAccount(userVO);
		} catch (Exception e) {
			return ERROR;
		}
		
		session.put("loginId", userVO.getUserName());
		
		return SUCCESS;
	}
	
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public List<Rol> getRols() {
		return rols;
	}
	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}
	public String getChoosenRoles() {
		return choosenRoles;
	}
	public void setChoosenRoles(String choosenRoles) {
		this.choosenRoles = choosenRoles;
	}
	public List<Locale> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Locale> languages) {
		this.languages = languages;
	}
	public String getDefaultLanguage() {
		return defaultLanguage;
	}
	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public LanguageService getLanguageService() {
		return languageService;
	}

	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

}
