package com.xuantujava.service;

import java.util.List;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.repository.PaidCourseRepository;

public interface IPaidCourseService  {
	void addPaidCourse (PaidCourseDTO paidcourseDTO);
	List<PaidCourseDTO> findAll();

}
