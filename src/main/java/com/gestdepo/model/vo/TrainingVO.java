package com.gestdepo.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrainingVO extends EventVO {
	
	List<ExerciseVO> exercises = new ArrayList();
	
	public TrainingVO(){
		// TODO
		super();
	}
	
	public TrainingVO(TrainingVO training){
		// TODO
		super(training);
	}
	
	public TrainingVO(long eventId, long seasonId, String title, long start, long end) {
		// TODO
		super(eventId, seasonId, title, start, end);
		
	}
	
}
