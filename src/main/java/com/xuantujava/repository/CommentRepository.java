package com.xuantujava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
	List<CommentEntity> findBycourseid(long courseid);
}
