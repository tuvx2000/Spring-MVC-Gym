package com.xuantujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{

}
