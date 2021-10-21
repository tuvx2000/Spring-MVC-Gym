package com.xuantujava.service;

import com.xuantujava.DTO.UserDTO;

public interface IUserService {
	void RegisterNewUser(UserDTO userDTO);

	int checkUserExisted(String string, int i);
	
	public Long findUserIdByUserName (String UserName);
}
