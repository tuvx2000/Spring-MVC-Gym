package com.xuantujava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.entity.PaidCourseEntity;
import com.xuantujava.repository.PaidCourseRepository;
import com.xuantujava.service.IPaidCourseService;

@Service
public class PaidCourseService implements IPaidCourseService{
	@Autowired
	PaidCourseRepository paidCourseRepository;
	
	@Override
	public void addPaidCourse(PaidCourseDTO paidcourseDTO) {
		PaidCourseEntity paidCourseEntity = new PaidCourseEntity();

		paidCourseEntity.setS3Path(paidcourseDTO.getS3Path());
		paidCourseEntity.setName(paidcourseDTO.getName());
		paidCourseEntity.setDescription(paidcourseDTO.getDescription());
		paidCourseEntity.setShortDescription(paidcourseDTO.getDescription());
		paidCourseEntity.setTopic(paidcourseDTO.getTopic());
		paidCourseEntity.setThumbnail(paidcourseDTO.getThumbnail());
		
		
		paidCourseRepository.save(paidCourseEntity);
		
	}

}
