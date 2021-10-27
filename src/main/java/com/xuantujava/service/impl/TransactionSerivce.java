package com.xuantujava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xuantujava.repository.TransactionRepository;
import com.xuantujava.service.ITransactionService;

public class TransactionSerivce implements ITransactionService{
	@Autowired
	TransactionRepository transactionRepository;
}
