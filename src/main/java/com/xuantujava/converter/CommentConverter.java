package com.xuantujava.converter;

import org.springframework.stereotype.Component;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.entity.CommentEntity;
import com.xuantujava.entity.FreeCourseEntity;

@Component
public class CommentConverter {
	
	public CommentDTO toDto(CommentEntity entity) {
		CommentDTO result = new CommentDTO();
		
		result.setComment(entity.getComment());
		result.setUserid(entity.getUserid());
		result.setParentIDCOMMENT(entity.getParentId());
		result.setCourseid(entity.getCourseid());
		
		return result;
	}
	
	public CommentEntity toEntity(CommentDTO dto) {
		CommentEntity result = new CommentEntity();
		
		result.setComment(dto.getComment());
		result.setUserid(dto.getUserid());
		result.setParentId(dto.getParentIDCOMMENT());
		result.setCourseid(dto.getCourseid());
		
		return result;
	}
}
