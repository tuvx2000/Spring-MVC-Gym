package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.entity.CommentEntity;
import com.xuantujava.entity.RatingEntity;
import com.xuantujava.repository.CommentRepository;
import com.xuantujava.repository.UserRepository;
import com.xuantujava.service.ICommentService;

@Service
public class CommentService implements ICommentService{
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<CommentDTO> listCommentByCourseId(Long courseId){
		System.out.println("day la lisat comment");
		
		
		List<CommentEntity> listEntity = commentRepository.findAll();
		List<CommentDTO> listDTO = new ArrayList<>();
		
		for (CommentEntity itemEntity : listEntity) {
			CommentDTO itemDTO = new CommentDTO();
			itemDTO.setComment(itemEntity.getComment());
			itemDTO.setCourseid(itemEntity.getCourseid());
			itemDTO.setParentIDCOMMENT(itemEntity.getParentId());
			itemDTO.setUserName(userRepository.findOne(itemEntity.getUserid()).getFullName());
			itemDTO.setUserImage("dang hoan thien");
			itemDTO.setIDCOMMENT(itemEntity.getId());
			


			listDTO.add(itemDTO);
		}
		
		
		
		
		return listDTO;
	}

}
