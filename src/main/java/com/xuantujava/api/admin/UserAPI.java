package com.xuantujava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.TransactionDTO;
import com.xuantujava.DTO.UserDTO;
import com.xuantujava.service.INewService;
import com.xuantujava.service.ITransactionService;
import com.xuantujava.service.IUserService;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {
	@Autowired
	private IUserService userService;
	@Autowired
	private ITransactionService transactionService;

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

	@PostMapping("/api/momo")
	public TransactionDTO momo(@RequestBody TransactionDTO transactionDTO) {
		transactionService.save(transactionDTO);
		
		if(transactionDTO.getDescription() == 1) {
			userService.updateStatusPaid(1, transactionDTO.getUserId());
		}
		
		
		
		System.out.println("ccccccccccccccccccccccc");
		return transactionDTO;
	}
}
