package com.xuantujava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.TransactionDTO;
import com.xuantujava.converter.UserConverter;
import com.xuantujava.entity.TransactionEntity;
import com.xuantujava.repository.TransactionRepository;
import com.xuantujava.repository.UserRepository;
import com.xuantujava.service.ITransactionService;
import com.xuantujava.service.IUserService;

@Service
public class TransactionSerivce implements ITransactionService{
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void save(TransactionDTO transactionDTO) {
		TransactionEntity entity = new TransactionEntity();
		entity.setAmount(transactionDTO.getAmount());
		entity.setOrderId(transactionDTO.getOrderId());
		entity.setDescription(transactionDTO.getDescription());
		entity.setUser(userRepository.findOne(transactionDTO.getUserId()));
		
		transactionRepository.save(entity);
		
	}
}
