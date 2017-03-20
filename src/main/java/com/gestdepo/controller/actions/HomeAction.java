package com.gestdepo.controller.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.I18nInterceptor;

import com.gestdepo.model.service.AccountService;
import com.gestdepo.model.service.LanguageService;
import com.gestdepo.model.vo.Rol;
import com.gestdepo.model.vo.UserVO;
import com.opensymphony.xwork2.Action;


public class HomeAction implements Action {
	
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	
	private LanguageService languageService;
	private AccountService accountService;
	
	private UserVO userVO;
	private List<Rol> rols = new ArrayList<Rol>();
	private List<Locale> languages;
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public LanguageService getLanguageService() {
		return languageService;
	}

	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
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

	public List<Locale> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Locale> languages) {
		this.languages = languages;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
