package com.gestdepo.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameVO extends EventVO {
	
	List<ExerciseVO> exercises = new ArrayList();

	public GameVO(){
		// TODO
		super();
		
	}
	
	public GameVO(GameVO game){
		// TODO
		super(game);
		
	}
	
	public GameVO(long eventId, long seasonId, String title, long start, long end) {
		// TODO Auto-generated constructor stub
		super(eventId, seasonId, title, start, end);
		
	}
	
}
