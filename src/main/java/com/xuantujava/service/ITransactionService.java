package com.xuantujava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.TransactionDTO;

public interface ITransactionService {

	void save(TransactionDTO transactionDTO);

	Integer getTotalItem();

	List<TransactionDTO> findAll(Pageable pageable);

	Integer getSumTransaction();
	
	
}
