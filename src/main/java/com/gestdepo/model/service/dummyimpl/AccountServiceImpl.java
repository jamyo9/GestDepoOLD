package com.gestdepo.model.service.dummyimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.gestdepo.model.exception.NoUserException;
import com.gestdepo.model.service.AccountService;
import com.gestdepo.model.vo.CoachVO;
import com.gestdepo.model.vo.CoordinatorVO;
import com.gestdepo.model.vo.PlayerVO;
import com.gestdepo.model.vo.Rol;
import com.gestdepo.model.vo.UserVO;

public class AccountServiceImpl implements AccountService {
	
	static long userId = 0l;
	static List<UserVO> users = new ArrayList<UserVO>();
	static List<Rol> rols = resetRols(new Locale("ES"));
	
	static {
		rols.remove(2);
		rols.remove(1);
		users.add(new CoachVO(++userId, 1l,"dummyCoach@email.com", "dummyCoach", "dummyCoach", "DummyCoachName", "DummyCoachLastName", "", new Locale("ES"), rols));
		rols = resetRols(new Locale("ES"));
		rols.remove(0);
		users.add(new CoordinatorVO(++userId, 1l, "dummyCoordinator@email.com", "dummyCoordinator", "dummyCoordinator", "DummyCoordinatorName", "DummyCoordinatorLastName", "", new Locale("ES"), rols));
		rols = resetRols(new Locale("ES"));
		rols.remove(0);
		rols.remove(0);
		users.add(new PlayerVO(++userId, 1l, "dummyPlayer@email.com", "dummyPlayer", "dummyPlayer", "DummyPlayerName", "DummyPlayerLastName", "", new Locale("ES"), rols));
	}
	@Override
	public UserVO loginUser(long userId, String email, String userName, String pwd) throws NoUserException {
		for (UserVO userTmp : users) {
			if (userName.equals(userTmp.getUserName())) {
				return userTmp;
			}
		}
		throw new NoUserException("The user doesn´t exists");
	}

	@Override
	public UserVO loginUser(UserVO userVO) throws NoUserException {
		for (UserVO userTmp : users) {
			if (userVO.getUserName().equals(userTmp.getUserName())) {
				return userTmp;
			}
		}
		throw new NoUserException("The user doesn´t exists");
	}

	@Override
	public UserVO getLogedUser(long loginId) throws NoUserException {
		for (UserVO userTmp : users) {
			if (loginId == userTmp.getUserId()) {
				return userTmp;
			}
		}
		throw new NoUserException("There is no user logged");
	}
	
	@Override
	public UserVO createAccount(UserVO userVO) {
		userVO.setUserId(++userId);
		return userVO;
	}

	@Override
	public List<Rol> getPossibleRols(Locale locale) {
		List<Rol> rols = new ArrayList<Rol>();
		rols.add(new Rol(1l, "Coordinator", "ES"));
		rols.add(new Rol(2l, "Coach", "ES"));
		rols.add(new Rol(3l, "Player", "ES"));
		return rols;
	}
	
	static public List<Rol> resetRols(Locale locale) {
		List<Rol> rols = new ArrayList<Rol>();
		rols.add(new Rol(1l, "Coordinator", "ES"));
		rols.add(new Rol(2l, "Coach", "ES"));
		rols.add(new Rol(3l, "Player", "ES"));
		return rols;
	}
}
