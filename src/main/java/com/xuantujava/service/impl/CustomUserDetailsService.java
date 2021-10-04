package com.xuantujava.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xuantujava.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	
//	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username,SystemConstant.ACTIVE_STATUS);
//		
//		if(userEntity == null) {
//			throw new UsernameNotFoundException("User not found");
//		}
//		
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		for (RoleEntity role: userEntity.getRoles()) {
//			authorities.add(new SimpleGrantedAuthority(role.getCode()));
//		}
//		
//		//push thong tin vao security khi user login vao he thong
//		MyUser myUser  = new MyUser(userEntity.getUserName(), userEntity.getPassWord(), 
//				true, true, true, true, authorities);
//		myUser.setFullName(userEntity.getFullName());
//		
		return null;
	}

}
