package com.xuantujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndByStatus(String name, int status);
}	
