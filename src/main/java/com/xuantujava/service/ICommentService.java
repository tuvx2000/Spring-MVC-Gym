package com.xuantujava.service;

import java.util.List;

import com.xuantujava.DTO.CommentDTO;

public interface ICommentService {
	List<CommentDTO> listCommentByCourseId(Long courseId);
}
