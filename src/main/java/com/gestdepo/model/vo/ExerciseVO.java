package com.gestdepo.model.vo;

import java.util.ArrayList;
import java.util.List;

public class ExerciseVO {
	
	private long exerciseId;
	private String name;
	private String description;
	
	// TODO imagen
	
	// number of players, it can be a number, a range, or a multiple
	// if numberOfPlayers is filled and multipleOfPlayers is not, then the number of players need will be a number.
	// if multipleOfPlayers is filled and numberOfPlayers is not, then the number of players need will be a multiple.
	// if both are filled in, then the number of players will be a range.
	private int numberOfPlayers;
	private int multipleOfPlayeres;
	private boolean numberNeeded;
	private boolean rangeNeeded;
	private boolean multipleNeeded;
	
	private String objective;
	private List<MaterialVO> materials;
	
	// exercise ownership (coach/team, club, all)
	// if the owner of the exercise is the coach, the rest of IDs will be null or 0l
	// if the owner of the exercise is the team, the rest of IDs will be null or 0l
	// if the owner of the exercise is the club, the rest of IDs will be null or 0l
	// if the exercise is visible for everybody, all the IDs will be null or 0l
	private long coachId;
	private long teamId;
	private long clubId;
	
	public ExerciseVO() {
		this.setExerciseId(0l);
		this.setName("");
		this.setDescription("");
		this.setNumberOfPlayers(0);
		this.setMultipleOfPlayeres(0);
		this.setNumberNeeded(false);
		this.setMultipleNeeded(false);
		this.setRangeNeeded(false);
		this.setObjective("");
		this.setMaterials(new ArrayList<MaterialVO>());
		this.setCoachId(0l);
		this.setTeamId(0l);
		this.setClubId(0l);
	}
	
	public ExerciseVO(long exerciseId, String name, String description,
			int numberOfPlayers, int multipleOfPlayers, String objective,
			List<MaterialVO> materials, long coachId, long teamId, long clubId) {
		this.setExerciseId(exerciseId);
		this.setName(name);
		this.setDescription(description);
		this.setNumberOfPlayers(numberOfPlayers);
		this.setMultipleOfPlayeres(multipleOfPlayers);
		
		this.setNumberNeeded(false);
		this.setMultipleNeeded(false);
		this.setRangeNeeded(false);
				
		if (numberOfPlayers != 0 && multipleOfPlayers != 0){
			this.setRangeNeeded(true);
		} else if (numberOfPlayers != 0 && multipleOfPlayers == 0){
			this.setNumberNeeded(true);
		} else if (numberOfPlayers == 0 && multipleOfPlayers != 0) {
			this.setMultipleNeeded(true);
		}
		
		this.setObjective(objective);
		this.setMaterials(materials);
		this.setCoachId(coachId);
		this.setTeamId(teamId);
		this.setClubId(clubId);
	}
	
	public ExerciseVO(ExerciseVO exercise) {
		this.setExerciseId(exercise.getExerciseId());
		this.setName(exercise.getName());
		this.setDescription(exercise.getDescription());
		this.setNumberOfPlayers(exercise.getNumberOfPlayers());
		this.setMultipleOfPlayeres(exercise.getMultipleOfPlayeres());
		this.setNumberNeeded(exercise.isNumberNeeded());
		this.setMultipleNeeded(exercise.isMultipleNeeded());
		this.setRangeNeeded(exercise.isRangeNeeded());
		this.setObjective(exercise.getObjective());
		this.setMaterials(exercise.getMaterials());
		this.setCoachId(exercise.getCoachId());
		this.setTeamId(exercise.getTeamId());
		this.setClubId(exercise.getClubId());
	}
	
	public long getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getMultipleOfPlayeres() {
		return multipleOfPlayeres;
	}
	public void setMultipleOfPlayeres(int multipleOfPlayeres) {
		this.multipleOfPlayeres = multipleOfPlayeres;
	}
	public boolean isNumberNeeded() {
		return numberNeeded;
	}
	public void setNumberNeeded(boolean numberNeeded) {
		this.numberNeeded = numberNeeded;
	}
	public boolean isRangeNeeded() {
		return rangeNeeded;
	}
	public void setRangeNeeded(boolean rangeNeeded) {
		this.rangeNeeded = rangeNeeded;
	}
	public boolean isMultipleNeeded() {
		return multipleNeeded;
	}
	public void setMultipleNeeded(boolean multipleNeeded) {
		this.multipleNeeded = multipleNeeded;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public List<MaterialVO> getMaterials() {
		return materials;
	}
	public void setMaterials(List<MaterialVO> materials) {
		this.materials = materials;
	}
	public long getCoachId() {
		return coachId;
	}
	public void setCoachId(long coachId) {
		this.coachId = coachId;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public long getClubId() {
		return clubId;
	}
	public void setClubId(long clubId) {
		this.clubId = clubId;
	}
}
