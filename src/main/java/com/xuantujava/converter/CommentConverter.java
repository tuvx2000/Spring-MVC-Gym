package com.xuantujava.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.DTO.UserDTO;
import com.xuantujava.entity.CommentEntity;
import com.xuantujava.entity.FreeCourseEntity;
import com.xuantujava.entity.NewEntity;
import com.xuantujava.service.IUserService;

@Component
public class CommentConverter {
	
	@Autowired
	IUserService userService;
	
	public CommentDTO toDto(CommentEntity entity) {
		CommentDTO result = new CommentDTO();
		
	//	UserDTO temp = userService.findById(entity.getUserid());
		
		result.setIDCOMMENT(entity.getId());
		result.setId(entity.getId());
		result.setComment(entity.getComment());
		result.setUserid(entity.getUserid());
		result.setParentIDCOMMENT(entity.getParentId());
		result.setCourseid(entity.getCourseid());
	//	result.setUserName(userService.findUserNameByUserId(entity.getUserid()));
		result.setUserFullName(userService.findById(entity.getUserid()).getFullName());
		return result;
	}
	
	public CommentEntity toEntity(CommentDTO dto) {
		CommentEntity result = new CommentEntity();
		
		result.setComment(dto.getComment());
		result.setUserid(dto.getUserid());
		result.setParentId(dto.getParentIDCOMMENT());
		result.setCourseid(dto.getCourseid());
		
		result.setUserid(dto.getUserid());

		
		return result;
	}
	
	
	public CommentEntity toEntity(CommentEntity result, CommentDTO dto) {
		result.setComment(dto.getComment());
		result.setUserid(dto.getUserid());
		result.setParentId(dto.getParentIDCOMMENT());
		result.setCourseid(dto.getCourseid());
		
		result.setUserid(dto.getUserid());
		return result;
	}
	
	
	
}
