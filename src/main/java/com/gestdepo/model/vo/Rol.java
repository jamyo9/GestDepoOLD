package com.gestdepo.model.vo;

import java.util.Locale;

public class Rol {
	
	private long rolId;
	private String name;
	private Locale locale;
	
	public Rol() {
		this.setRolId(0L);
		this.setName("");
		this.setLocale(new Locale(""));
	}
	public Rol(long rolId, String name, String locale) {
		this.setRolId(rolId);
		this.setName(name);
		this.setLocale(new Locale(locale));
	}
	
	public long getRolId() {
		return rolId;
	}
	public void setRolId(long rolId) {
		this.rolId = rolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
