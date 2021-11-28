package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.DTO.TransactionDTO;
import com.xuantujava.converter.UserConverter;
import com.xuantujava.entity.NewEntity;
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

	@Override
	public Integer getTotalItem() {
		return (int) transactionRepository.count();

	}
	
	@Override
	public Integer getSumTransaction() {
		int sum = 0;
		List<TransactionEntity> entities = transactionRepository.findAll();
		for (TransactionEntity item: entities) {
			if(item.getDescription() == 1)
				sum += item.getAmount();
		}
		return sum;

	}
	

	@Override
	public List<TransactionDTO> findAll(Pageable pageable) {
		List<TransactionDTO> models = new ArrayList<>();
		List<TransactionEntity> entities = transactionRepository.findAll(pageable).getContent();
		for (TransactionEntity item: entities) {
			TransactionDTO newDTO = new TransactionDTO();
			newDTO.setAmount(item.getAmount());
			newDTO.setOrderId(item.getOrderId());
			newDTO.setDescription(item.getDescription());
			newDTO.setUserId(item.getUser().getId());
			models.add(newDTO);
		}
		return models;
	}
}
