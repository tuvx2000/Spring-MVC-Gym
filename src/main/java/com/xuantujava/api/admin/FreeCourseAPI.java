package com.xuantujava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.service.ICommentService;
import com.xuantujava.service.IFreeCourseService;

@RestController(value = "freecourseAPIOfAdmin")
public class FreeCourseAPI {
	@Autowired
	private IFreeCourseService freeCourseService;
	
	@PostMapping("/api/freecourse")
	public FreeCourseDTO createfreecourse(@RequestBody FreeCourseDTO addComment) {
//		System.out.println("comment API(add):"+ addComment.getComment());
		System.out.println("comment ID API(post):"+ addComment.getId());
		
		freeCourseService.save(addComment);
		
		return addComment;
	}
	
	@PutMapping("/api/freecourse")
	public FreeCourseDTO updatefreecourse(@RequestBody FreeCourseDTO updateComment) {
		System.out.println("comment ID API(put):"+ updateComment.getId());
		freeCourseService.save(updateComment);

		return updateComment;
	}
	
	@DeleteMapping("/api/freecourse")
	public void deletefreecourse(@RequestBody long[] ids) {	
		freeCourseService.delete(ids);
	}
}
