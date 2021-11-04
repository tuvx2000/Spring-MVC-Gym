package com.xuantujava.converter;

import org.springframework.stereotype.Component;

import com.xuantujava.DTO.CategoryDTO;
import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.entity.CategoryEntity;
import com.xuantujava.entity.FreeCourseEntity;
import com.xuantujava.entity.NewEntity;

@Component
public class FreeCourseConverter {
	public FreeCourseDTO toDto(FreeCourseEntity entity) {
		FreeCourseDTO result = new FreeCourseDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setLinkyoutube(entity.getLinkyoutube());
		result.setDescription(entity.getDescription());
		result.setSentiment(entity.getSentiment());
		result.setTopic(entity.getTopic());
		return result;
	}
	
	public FreeCourseEntity toEntity(FreeCourseDTO dto) {
		FreeCourseEntity result = new FreeCourseEntity();
		result.setName(dto.getName());
		result.setLinkyoutube(dto.getLinkyoutube());
		result.setDescription(dto.getDescription());
		result.setSentiment(dto.getSentiment());
		result.setTopic(dto.getTopic());
		result.setThumbnail(dto.getThumbnail());


		return result;
	}
	
	public FreeCourseEntity toEntity(FreeCourseEntity result, FreeCourseDTO dto) {

		result.setThumbnail(dto.getThumbnail());

		result.setTopic(dto.getTopic());
		result.setName(dto.getName());
		result.setLinkyoutube(dto.getLinkyoutube());
		result.setDescription(dto.getDescription());
		result.setSentiment(dto.getSentiment());
		return result;
	}
}
