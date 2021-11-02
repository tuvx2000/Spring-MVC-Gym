package com.xuantujava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.NewDTO;

public interface ICommentService {
	List<CommentDTO> listCommentByCourseId(Long courseId);
	 void addComment(CommentDTO commentDTO);
	 
	 
	 List<CommentDTO> findAll(Pageable pageable);
	 int getTotalItem();
	 
	 public CommentDTO save(CommentDTO dto);
	 
	 CommentDTO findById(long id);
	void delete(long[] ids);

}
