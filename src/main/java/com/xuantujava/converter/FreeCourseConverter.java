package com.xuantujava.converter;

import org.springframework.stereotype.Component;

import com.xuantujava.DTO.CategoryDTO;
import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.entity.CategoryEntity;
import com.xuantujava.entity.FreeCourseEntity;

@Component
public class FreeCourseConverter {
	public FreeCourseDTO toDto(FreeCourseEntity entity) {
		FreeCourseDTO result = new FreeCourseDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setLinkyoutube(entity.getLinkyoutube());
		result.setDescription(entity.getDescription());
		result.setSentiment(entity.getSentiment());
		return result;
	}
	
	public FreeCourseEntity toEntity(FreeCourseDTO dto) {
		FreeCourseEntity result = new FreeCourseEntity();
		result.setName(dto.getName());
		result.setLinkyoutube(dto.getLinkyoutube());
		result.setDescription(dto.getDescription());
		result.setSentiment(dto.getSentiment());
		return result;
	}
}
