package com.gestdepo.model.vo;


public abstract class EventVO {
	
	private long eventId;
	private long seasonId;
	private String title;
	private long start;
	private long end;

	public EventVO() {
		this.setEventId(0l);
		this.setSeasonId(0l);
		this.setTitle("");
		this.setStart(System.currentTimeMillis());
		this.setEnd(System.currentTimeMillis());
	}
	
	public EventVO(EventVO event) {
		this.setEventId(event.getEventId());
		this.setSeasonId(event.getSeasonId());
		this.setTitle(event.getTitle());
		this.setStart(event.getStart());
		this.setEnd(event.getEnd());
	}
	
	public EventVO(long eventId, long seasonId, String title, long start, long end) {
		this.setEventId(eventId);
		this.setSeasonId(seasonId);
		this.setTitle(title);
		this.setStart(start);
		this.setEnd(end);
	}
	
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public long getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(long seasonId) {
		this.seasonId = seasonId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
}
