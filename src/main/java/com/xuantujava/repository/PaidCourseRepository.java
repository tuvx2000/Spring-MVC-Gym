package com.xuantujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.entity.PaidCourseEntity;

public interface PaidCourseRepository extends JpaRepository<PaidCourseEntity, Long>{
	PaidCourseEntity findOneByS3Path(String s3Path);
}
