package com.xuantujava.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.xuantujava.DTO.CategoryDTO;
import com.xuantujava.DTO.UserDTO;
import com.xuantujava.entity.CategoryEntity;
import com.xuantujava.entity.RoleEntity;
import com.xuantujava.entity.UserEntity;
import com.xuantujava.repository.RoleRepository;


@Component
public class UserConverter {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    private RoleRepository roleRepository;
	
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		
		result.setUserName(entity.getUserName());
		result.setFullName(entity.getFullName());

		result.setPassword(entity.getPassword());
	
		
		result.setRoleId(2L);
		result.setStatus(entity.getStatus());
		result.setStatusPaid(entity.getStatusPaid());
		
		return result;
		
	}
	
	public UserEntity toEntity(UserDTO dto) {

		UserEntity result = new UserEntity();
		
		result.setUserName(dto.getUserName());
		result.setFullName(dto.getFullName());

		result.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		
		List<RoleEntity> roles = new ArrayList<>();	
		RoleEntity role = roleRepository.findOne(2l);	
		roles.add(role);
		result.setRoles(roles);
		
		
		result.setStatus(dto.getStatus());
		result.setStatusPaid(dto.getStatusPaid());
		
		return result;
	}
}
