package com.gestdepo.model.service;

import java.util.List;
import java.util.Locale;

import com.gestdepo.model.exception.NoUserException;
import com.gestdepo.model.vo.Rol;
import com.gestdepo.model.vo.UserVO;

public interface AccountService {
	
	public UserVO loginUser(long userId, String email, String userName, String pwd) throws NoUserException;
	public UserVO loginUser(UserVO userVO) throws NoUserException;

	public UserVO getLogedUser(long loginId) throws NoUserException;
	
	public UserVO createAccount(UserVO userVO);
	
	public List<Rol> getPossibleRols(Locale locale);
		
}
