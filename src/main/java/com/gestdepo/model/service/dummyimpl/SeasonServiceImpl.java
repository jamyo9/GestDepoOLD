package com.gestdepo.model.service.dummyimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gestdepo.model.service.SeasonService;
import com.gestdepo.model.vo.SeasonVO;

public class SeasonServiceImpl implements SeasonService {
	
	static long seasonId = 0l;
	static List<SeasonVO> seasons = new ArrayList<SeasonVO>();
	static {
		seasons.add(new SeasonVO(1l, "Season 1", new Date(), new Date(), 1l));
		seasons.add(new SeasonVO(2l, "Season 2", new Date(), new Date(), 2l));
		seasons.add(new SeasonVO(3l, "Season 3", new Date(), new Date(), 3l));
	}
	
	@Override
	public void saveSeason(SeasonVO seasonVO) {
		if (seasonVO.getSeasonId() != 0l){
			int index = seasons.indexOf(getSeason(seasonVO.getSeasonId()));
			seasons.remove(index);
			seasons.add(seasonVO);
		} else {
			seasonVO.setSeasonId(seasonId++);
			seasons.add(seasonVO);
		}
	}
	
	@Override
	public List<SeasonVO> getCoachSeasions(long userId) {
		return seasons;
	}

	@Override
	public String deleteSeason(long seasonId) {
		try {
			for (SeasonVO season : seasons) {
				if (season.getSeasonId() == seasonId) {
					seasons.remove(season);
				}
			}
		} catch (Exception e) {
			return "ERROR";
		}
		return "";
	}

	@Override
	public SeasonVO getSeason(long seasonId) {
		for (SeasonVO season : seasons) {
			if (season.getSeasonId() == seasonId) {
				return season;
			}
		}
		return null;
	}	
}
