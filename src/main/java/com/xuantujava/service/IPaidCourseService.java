package com.xuantujava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.xuantujava.DTO.PaidCourseDTO;

public interface IPaidCourseService  {
	void addPaidCourse (PaidCourseDTO PaidCourseDTO);
	List<PaidCourseDTO> findAll();
	void save (PaidCourseDTO PaidCourseDTO);
	PaidCourseDTO findOne(Long courseId);
	
	int getTotalItem();
	List<PaidCourseDTO> findAll(Pageable pageable);
	
}
