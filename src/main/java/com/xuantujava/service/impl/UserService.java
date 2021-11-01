package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.DTO.UserDTO;
import com.xuantujava.constant.SystemConstant;
import com.xuantujava.converter.UserConverter;
import com.xuantujava.entity.NewEntity;
import com.xuantujava.entity.RoleEntity;
import com.xuantujava.entity.UserEntity;
import com.xuantujava.repository.RoleRepository;
import com.xuantujava.repository.UserRepository;
import com.xuantujava.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private UserConverter userConverter;
	
	public String findUserNameByUserId(Long userId) {
		return  userRepository.findOne(userId).getUserName();
	}
	
	
	public int checkUserExisted (String userName, int status) {
		
		if(userRepository.findOneByUserNameAndStatus(userName, status) == null)
			return 0;
		
		return 1;
	}
	
	public Long findUserIdByUserName (String UserName) {
			
		return userRepository.findOneByUserNameAndStatus(UserName, 1).getId();
	}
	
	public int findUserStatusPaidByUserName (String UserName) {
		
		return userRepository.findOneByUserNameAndStatus(UserName, 1).getStatusPaid();
	}
	
	
	
	@Override
	public void RegisterNewUser(UserDTO userDTO) {
		if(checkUserExisted(userDTO.getUserName(),SystemConstant.ACTIVE_STATUS) == 1) return;
		
		
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setFullName(userDTO.getFullName());

		userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		
		List<RoleEntity> roles = new ArrayList<>();	
		RoleEntity role = roleRepository.findOne(2l);				
		roles.add(role);
		
		userEntity.setRoles(roles);
		
		userEntity.setStatus(1);
		userEntity.setStatusPaid(0);
		
		userRepository.save(userEntity);
		
	}

	@Override
	public void updateStatusPaid(int status, Long userId) {
		UserEntity user =  userRepository.findOne(userId);	
		user.setStatusPaid(status);
		userRepository.save(user);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDto(item);
			models.add(userDTO);
		}
		return models;
	}



}
