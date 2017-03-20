package com.gestdepo.controller.actions;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	
	public String test() {
		return SUCCESS;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}
}