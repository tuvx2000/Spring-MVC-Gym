package com.xuantujava.converter;

import org.springframework.stereotype.Component;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.entity.FreeCourseEntity;
import com.xuantujava.entity.PaidCourseEntity;

@Component
public class PaidCourseConverter {
	public PaidCourseDTO toDto(PaidCourseEntity entity) {
		PaidCourseDTO result = new PaidCourseDTO();

		result.setS3Path(entity.getS3Path());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		result.setTopic(entity.getTopic());
		result.setThumbnail(entity.getThumbnail());
		result.setSentiment(entity.getSentiment());
		result.setShortDescription(entity.getShortDescription());
		result.setId(entity.getId());

		return result;
	}

	public PaidCourseEntity toEntity(PaidCourseEntity dto) {
		PaidCourseEntity result = new PaidCourseEntity();

		result.setS3Path(dto.getS3Path());;
		result.setName(dto.getName());
		result.setDescription(dto.getDescription());
		result.setTopic(dto.getTopic());
		result.setThumbnail(dto.getThumbnail());
		result.setSentiment(dto.getSentiment());
		result.setShortDescription(dto.getShortDescription());

		return result;
	}
}
