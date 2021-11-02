package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.converter.CommentConverter;
import com.xuantujava.entity.CategoryEntity;
import com.xuantujava.entity.CommentEntity;
import com.xuantujava.entity.FreeCourseEntity;
import com.xuantujava.entity.NewEntity;
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
	
	@Autowired
	CommentConverter commentConverter;
	
	public List<CommentDTO> listCommentByCourseId(Long courseId){
		//System.out.println("day la lisat comment");
		
		
		List<CommentEntity> listEntity = commentRepository.findBycourseid(courseId);
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
	
	@Override
	@Transactional
	public CommentDTO save(CommentDTO dto) {
		CommentEntity commentEntity = new CommentEntity();
		if (dto.getId() != null) {
			CommentEntity oldComment = commentRepository.findOne(dto.getId());
			commentEntity = commentConverter.toEntity(oldComment, dto);
		} else {
			commentEntity = commentConverter.toEntity(dto);
		}
		return commentConverter.toDto(commentRepository.save(commentEntity));
	}
	
	
	
	public void addComment(CommentDTO commentDTO) {
		
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setComment(commentDTO.getComment());
		commentEntity.setUserid(commentDTO.getUserid());
		commentEntity.setParentId(commentDTO.getParentIDCOMMENT());
		commentEntity.setCourseid(commentDTO.getCourseid());
		
	
		//System.out.println("xxx:" +commentEntity.getComment() +"/"+ commentEntity.getCourseid()  +"/"+  commentEntity.getUserid()  +"/"+  commentEntity.getParentId());
		
		commentRepository.save(commentEntity);
		
	}

	@Override
	public List<CommentDTO> findAll(Pageable pageable) {
		List<CommentDTO> models = new ArrayList<>();
		List<CommentEntity> entities = commentRepository.findAll(pageable).getContent();
		for (CommentEntity item: entities) {
			CommentDTO commentDTO = commentConverter.toDto(item);
			models.add(commentDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) commentRepository.count();
	}

	@Override
	public CommentDTO findById(long id) {
		CommentEntity entity = commentRepository.findOne(id);
		return commentConverter.toDto(entity);
	}
	
	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			commentRepository.delete(id);
		}
	}
	

}
