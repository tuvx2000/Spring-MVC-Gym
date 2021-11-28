package com.xuantujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.entity.TransactionEntity;
import com.xuantujava.entity.UserEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>{

	

}
