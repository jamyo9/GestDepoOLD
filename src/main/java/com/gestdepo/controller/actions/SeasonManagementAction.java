package com.gestdepo.controller.actions;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.gestdepo.model.exception.NoUserException;
import com.gestdepo.model.service.AccountService;
import com.gestdepo.model.service.SeasonService;
import com.gestdepo.model.vo.SeasonVO;
import com.gestdepo.model.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;

public class SeasonManagementAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private UserVO userVO;
	private SeasonVO seasonVO;
	//private SeasonVO addedSeasonVO;
	
	private List<SeasonVO> seasons;

	private String seasonId;
	
	private AccountService accountService;
	private SeasonService seasonService;
	
	private Map<String, Object> session;
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	public String preSaveSeason() {
		long loginId = (long) session.get("loginId");
		try {
			this.setUserVO(accountService.getLogedUser(loginId));
			
			// 1A. IF THE SEASONID IS NULL THEN WE ARE GOING TO CREATE A NEW SEASON
			if (this.seasonId == null) {
				this.setSeasonVO(new SeasonVO());
				this.getSeasonVO().setCoachId(this.userVO.getUserId());
			} else {
			// 1B. OTHERWISE, WE ARE GOING TO UPDATE A SEASON
				this.setSeasonVO(seasonService.getSeason(Long.parseLong(this.seasonId)));
			}
			
			// 2. LOAD THE SEASONS FROM DB
			this.setSeasons(seasonService.getCoachSeasions(this.userVO.getUserId()));
		} catch (NoUserException e) {
			addActionError(getText("login.error"));
		}
		return SUCCESS;
	}

	public String saveSeason() {
		// TODO NEED TO MODIFY THIS METHOD, SO WE WON´T CALL DB TO RELOAD THE LIST.
		//		THE IDEA IS TO MAKE ONLY ONE CALL TO  ADD THE NEW SEASON, AND WITH JQUERY ADD IT TO THE LIST
		try {
			// 1.SAVE THE NEW SEASON
			LocalDate localDate = LocalDate.parse(seasonVO.getStartDate().toString());
			
			seasonService.saveSeason(seasonVO);
			
			// 2. LOAD THE SEASONS FROM DB
			this.setSeasons(seasonService.getCoachSeasions(this.seasonVO.getCoachId()));
			
			// 3. RESET THE SEASONVO
			this.setSeasonVO(new SeasonVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public String deleteSeason() {
		// TODO NEED TO MODIFY THIS METHOD, SO WE WON´T CALL DB TO RELOAD THE LIST.
		//		THE IDEA IS TO MAKE ONLY ONE CALL TO  DELETE THE NEW SEASON, AND WITH JQUERY REMOVE IT FROM THE LIST
		// 1. GET THE SEASONID
		if (this.seasonId == null) {
			this.seasonId = request.getParameter("seasonId");	
		}
		
		// 2. DELETE THE SEASON FROM DB
		String error = "";
		error = seasonService.deleteSeason(Long.parseLong(this.seasonId));
		
		// 2. LOAD THE SEASONS FROM DB
		this.setSeasons(seasonService.getCoachSeasions(this.seasonVO.getCoachId()));
		
		if (!error.isEmpty()) {
			addActionError(error);
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
	public SeasonVO getSeasonVO() {
		return seasonVO;
	}
	public void setSeasonVO(SeasonVO seasonVO) {
		this.seasonVO = seasonVO;
	}
	public List<SeasonVO> getSeasons() {
		return seasons;
	}
/*
	public SeasonVO getAddedSeasonVO() {
		return addedSeasonVO;
	}
	public void setAddedSeasonVO(SeasonVO addedSeasonVO) {
		this.addedSeasonVO = addedSeasonVO;
	}
*/
	public void setSeasons(List<SeasonVO> seasons) {
		this.seasons = seasons;
	}
	public String getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
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
