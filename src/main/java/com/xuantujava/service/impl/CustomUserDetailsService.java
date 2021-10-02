package com.xuantujava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xuantujava.constant.SystemConstant;
import com.xuantujava.entity.UserEntity;
import com.xuantujava.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity userEntity = userRepository.findOneByUserNameAndByStatus(username, SystemConstant.ACTIVE_STATUS);
		
		if(userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		//push thong tin vao security khi user login vao he thong
		
		return null;
	}

}
