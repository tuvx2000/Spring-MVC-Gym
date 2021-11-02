package com.xuantujava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.service.ICommentService;
import com.xuantujava.service.INewService;

@RestController(value = "commentAPIOfAdmin")
public class CommentAPI {
	@Autowired
	private ICommentService commentService;
	
	@PostMapping("/api/comment")
	public CommentDTO createComment(@RequestBody CommentDTO addComment) {
//		System.out.println("comment API(add):"+ addComment.getComment());
//		System.out.println("comment ID API(add):"+ addComment.getId());
		
		commentService.save(addComment);
		
		return addComment;
	}
	
	@PutMapping("/api/comment")
	public CommentDTO updateComment(@RequestBody CommentDTO updateComment) {
		commentService.save(updateComment);

		return updateComment;
	}
	
	@DeleteMapping("/api/comment")
	public void deleteComment(@RequestBody long[] ids) {	
		commentService.delete(ids);
	}
}
