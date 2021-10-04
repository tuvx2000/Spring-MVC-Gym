package com.xuantujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.entity.NewEntity;

//import com.xuantujava.entity.UserEntity;


//@Repository
public interface UserRepository extends JpaRepository<NewEntity, Long> {
//	UserEntity findOneByUserNameAndStatus(String name, int status);
}