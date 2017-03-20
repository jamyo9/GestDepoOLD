package com.gestdepo.model.service;

import java.util.List;

import com.gestdepo.model.vo.EventVO;
import com.gestdepo.model.vo.SeasonVO;

public interface SeasonService {

	void saveSeason(SeasonVO seasonVO);

	List<SeasonVO> getCoachSeasions(long userId);

	String deleteSeason(long seasonId);
	
	SeasonVO getSeason(long seasonId);
}
