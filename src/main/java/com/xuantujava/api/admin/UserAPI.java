package com.xuantujava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.UserDTO;
import com.xuantujava.service.INewService;
import com.xuantujava.service.IUserService;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {
	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user")
	public UserDTO createNew(@RequestBody UserDTO userDTO) {
		userService.save(userDTO);
		
		return userDTO;
	}
	
	@PutMapping("/api/user")
	public UserDTO updateNew(@RequestBody UserDTO updateUser) {
		userService.save(updateUser);

		return updateUser;
	}
	
	@DeleteMapping("/api/user")
	public void deleteNew(@RequestBody long[] ids) {	
		userService.delete(ids);
	}
}
