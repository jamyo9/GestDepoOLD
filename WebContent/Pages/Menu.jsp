<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

MENU.JSP

<s:a action="homeAction" id="homeLink"><s:text name="application.home" /></s:a>

<s:a action="preSaveSeason" id="preSaveSeasonLink"><s:text name="season.manage" /></s:a>

<s:a action="manageExercises" id="manageExercisesLink"><s:text name="exercise.manage" /></s:a>