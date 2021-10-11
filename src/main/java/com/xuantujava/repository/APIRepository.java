package com.xuantujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.entity.APIEntity;
import com.xuantujava.entity.NewEntity;

public interface APIRepository extends JpaRepository<APIEntity, Long> {
	
}
