package com.xuantujava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.service.INewService;
import com.xuantujava.service.IPaidCourseService;

@RestController(value = "courseAPIOfAdmin")
public class CourseAPI {
	@Autowired
	private IPaidCourseService paidCourseService;
	
	
}
