package com.xuantujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.entity.FreeCourseEntity;

public interface FreeCourseRepository extends JpaRepository<FreeCourseEntity, Long>{
	FreeCourseEntity findOneByLinkyoutube(String linkYoutube);
}
