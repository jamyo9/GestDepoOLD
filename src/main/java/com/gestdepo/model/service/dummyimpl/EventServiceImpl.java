package com.gestdepo.model.service.dummyimpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.gestdepo.model.service.EventService;
import com.gestdepo.model.vo.EventVO;
import com.gestdepo.model.vo.GameVO;
import com.gestdepo.model.vo.TrainingVO;

public class EventServiceImpl implements EventService {
	
	static long eventId = 0l;
	static List<EventVO> events = new ArrayList<EventVO>();
	
	static Calendar calStart = Calendar.getInstance();
	static Calendar calEnd = Calendar.getInstance();
	
	static {
		//Year, month, day of month, hours, minutes and seconds
		calStart.set(2015, Calendar.MAY, 9, 16, 30, 00);
		calEnd.set(2015, Calendar.MAY, 9, 18, 30, 00);
		events.add(new TrainingVO(1l, 1l, "Training 1", calStart.getTimeInMillis(), calEnd.getTimeInMillis()));
		
		calStart.set(2015, Calendar.MAY, 10, 16, 30, 00);
		calEnd.set(2015, Calendar.MAY, 10, 18, 30, 00);
		events.add(new TrainingVO(2l, 1l, "Training 2",  calStart.getTimeInMillis(), calEnd.getTimeInMillis()));
		
		calStart.set(2015, Calendar.MAY, 11, 16, 30, 00);
		calEnd.set(2015, Calendar.MAY, 11, 18, 30, 00);
		events.add(new TrainingVO(3l, 1l, "Training 3", calStart.getTimeInMillis(), calEnd.getTimeInMillis()));
		
		calStart.set(2015, Calendar.MAY, 12, 16, 30, 00);
		calEnd.set(2015, Calendar.MAY, 12, 18, 30, 00);
		events.add(new TrainingVO(4l, 1l, "Training 4", calStart.getTimeInMillis(), calEnd.getTimeInMillis()));
		
		calStart.set(2015, Calendar.MAY, 14, 15, 00, 00);
		calEnd.set(2015, Calendar.MAY, 14, 19, 30, 00);
		events.add(new GameVO(5l, 1l, "Game 1",  calStart.getTimeInMillis(), calEnd.getTimeInMillis()));
	}
	
	@Override
	public void saveEvent(EventVO eventVO) {
		if (eventVO.getEventId() != 0l){
			int index = events.indexOf(getEvent(eventVO.getEventId()));
			events.remove(index);
			events.add(eventVO);
		} else {
			eventVO.setEventId(eventId++);
			events.add(eventVO);
		}
	}
	
	@Override
	public List<EventVO> getSeasionEvents(long seasonId) {
		return events;
	}

	@Override
	public String deleteEvent(long eventId) {
		try {
			for (EventVO event : events) {
				if (event.getEventId() == eventId) {
					events.remove(event);
				}
			}
		} catch (Exception e) {
			return "ERROR";
		}
		return "";
	}

	@Override
	public EventVO getEvent(long eventId) {
		for (EventVO event : events) {
			if (event.getEventId() == eventId) {
				return event;
			}
		}
		return null;
	}	
}
