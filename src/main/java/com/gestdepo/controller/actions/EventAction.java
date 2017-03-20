package com.gestdepo.controller.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.gestdepo.model.service.AccountService;
import com.gestdepo.model.service.EventService;
import com.gestdepo.model.service.SeasonService;
import com.gestdepo.model.vo.EventVO;
import com.gestdepo.model.vo.GameVO;
import com.gestdepo.model.vo.TrainingVO;
import com.gestdepo.utils.TimeUtils;
import com.opensymphony.xwork2.ActionSupport;

public class EventAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private EventVO eventVO;
	private String datePicked;
	private int eventType;
	
	private AccountService accountService;
	private SeasonService seasonService;
	private EventService eventService;
	
	private Map<String, Object> session;
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	
	private String title;
	private String start;
	private String end;
	private String seasonId;
	private String eventId;
	
	
	public String saveEvent() {
		// TODO
		String[] timeArray = TimeUtils.splitTime(this.start);
		long startLong = Long.parseLong(datePicked) + TimeUtils.getMillisecons(timeArray[0], timeArray[1], (timeArray[2].equalsIgnoreCase("PM"))?true:false);
		
		timeArray = TimeUtils.splitTime(this.end);
		long endLong = Long.parseLong(datePicked) + TimeUtils.getMillisecons(timeArray[0], timeArray[1], (timeArray[2].equalsIgnoreCase("PM"))?true:false);
		
		long eventIdLong = Long.parseLong((this.eventId==null || this.eventId.equals(""))?"0":this.eventId);
		long seasonIdLong = Long.parseLong(this.seasonId);
		
		if (eventType == 1) {
			this.setEventVO(new TrainingVO(eventIdLong, seasonIdLong, this.title, startLong, endLong));
		} else if (eventType == 2){
			this.setEventVO(new GameVO(eventIdLong, seasonIdLong, this.title, startLong, endLong));
		}
		
		eventService.saveEvent(this.eventVO);
		
		return SUCCESS;
	}
	
	public EventVO getEventVO() {
		return eventVO;
	}
	public void setEventVO(EventVO eventVO) {
		this.eventVO = eventVO;
	}

	public String getDatePicked() {
		return datePicked;
	}

	public void setDatePicked(String datePicked) {
		this.datePicked = datePicked;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
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
