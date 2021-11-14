package com.xuantujava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.DTO.UserDTO;

public interface IUserService {
	void RegisterNewUser(UserDTO userDTO);

	int checkUserExisted(String string, int i);
	
	public Long findUserIdByUserName (String UserName);
	
	public int findUserStatusPaidByUserName (String UserName);

	public String findUserNameByUserId(Long userId);
	
	public void updateStatusPaid (int status, Long userId);
	
	int getTotalItem();
	List<UserDTO> findAll(Pageable pageable);
	
	
	UserDTO findById(long id);

	///api
	UserDTO save(UserDTO dto);
	void delete(long[] ids);

	
	
}
