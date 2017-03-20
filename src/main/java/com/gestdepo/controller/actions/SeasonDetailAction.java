package com.gestdepo.controller.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.gestdepo.model.service.AccountService;
import com.gestdepo.model.service.EventService;
import com.gestdepo.model.service.SeasonService;
import com.gestdepo.model.vo.EventVO;
import com.gestdepo.model.vo.SeasonVO;
import com.gestdepo.model.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;

public class SeasonDetailAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private UserVO userVO;
	private SeasonVO seasonVO;
	
	private long seasonId;
	
	private long currentDate;
	private List<EventVO> events = new ArrayList();
	
	private AccountService accountService;
	private SeasonService seasonService;
	private EventService eventService;
	
	private Map<String, Object> session;
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	public String planSeason() {
		// TODO
		this.setSeasonVO(seasonService.getSeason(this.seasonId));
		this.setCurrentDate(System.currentTimeMillis());
		this.setEvents(eventService.getSeasionEvents(this.getSeasonVO().getSeasonId()));
		return SUCCESS;
	}
	
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public SeasonVO getSeasonVO() {
		return seasonVO;
	}
	public void setSeasonVO(SeasonVO seasonVO) {
		this.seasonVO = seasonVO;
	}
	public long getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(long seasonId) {
		this.seasonId = seasonId;
	}

	public long getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(long currentDate) {
		this.currentDate = currentDate;
	}

	public List<EventVO> getEvents() {
		return events;
	}

	public void setEvents(List<EventVO> events) {
		this.events = events;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public AccountService getAccountService() {
		return this.accountService;
	}

	public void setSeasonService(SeasonService seasonService) {
		this.seasonService = seasonService;
	}
	public SeasonService getSeasonService() {
		return this.seasonService;
	}
	
	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
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
