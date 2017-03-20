package com.gestdepo.model.service;

import java.util.List;

import com.gestdepo.model.vo.EventVO;

public interface EventService {

	void saveEvent(EventVO eventVO);

	String deleteEvent(long eventId);

	EventVO getEvent(long eventId);

	List<EventVO> getSeasionEvents(long seasonId);

}
