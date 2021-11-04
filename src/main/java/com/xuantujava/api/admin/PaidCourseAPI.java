package com.xuantujava.api.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.service.ICommentService;
import com.xuantujava.service.INewService;
import com.xuantujava.service.IPaidCourseService;

@RestController(value = "paidCourseAPIOfAdmin")
public class PaidCourseAPI {
	@Autowired
	private IPaidCourseService paidCourseService;
	
	@Autowired
	private ICommentService commentService;
	
	@PostMapping("/api/paidcourse")
	public PaidCourseDTO createComment(@RequestBody PaidCourseDTO addPaidCourse) {
		System.out.println("'POST' comment API(add):"+ addPaidCourse.getName());
		System.out.println("comment ID API(add):"+ addPaidCourse.getId());
		
		paidCourseService.save(addPaidCourse);
		
		return addPaidCourse;
	}
	
	@PutMapping("/api/paidcourse")
	public PaidCourseDTO updatePaidCourse(@RequestBody PaidCourseDTO updatePaidCourse) {
		System.out.println("'PUT' comment ID API(add):"+ updatePaidCourse.getId());
		System.out.println("'PUT' comment ID API(add):"+ updatePaidCourse.getName());

		paidCourseService.save(updatePaidCourse);

		return updatePaidCourse;
	}
	
	@DeleteMapping("/api/paidcourse")
	public void deletePaidCourse(@RequestBody long[] ids) {	
	
		commentService.deleteCommentsByCoursesId(ids);
				
		paidCourseService.delete(ids);
		
	}
}
