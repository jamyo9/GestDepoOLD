package com.gestdepo.model.vo;

import java.util.Date;

public class SeasonVO {
	
	private long seasonId;
	private String name;
	private Date startDate;
	private Date endDate;
	private long coachId;
	
	public SeasonVO() {
		this.setSeasonId(0l);
		this.setName("");
		this.setStartDate(null);
		this.setEndDate(null);
		this.setCoachId(0l);
	}

	public SeasonVO(long seasonId, String name, Date startDate, Date endDate, long coachId) {
		this.setSeasonId(seasonId);
		this.setName(name);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setCoachId(coachId);
	}
	
	public long getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(long seasonId) {
		this.seasonId = seasonId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getCoachId() {
		return this.coachId;
	}
	public void setCoachId(long coachId) {
		this.coachId = coachId;
	}
}
