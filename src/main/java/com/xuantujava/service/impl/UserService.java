package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.UserDTO;
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
	

	@Override
	public void RegisterNewUser(UserDTO userDTO) {
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setFullName(userDTO.getFullName());

		userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		
		List<RoleEntity> roles = new ArrayList<>();	
		RoleEntity role = roleRepository.findOne(2l);				
		roles.add(role);
		
		userEntity.setRoles(roles);
		
		userEntity.setStatus(1);

		
		userRepository.save(userEntity);
		
	}

}
