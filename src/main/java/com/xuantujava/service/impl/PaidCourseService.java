package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<PaidCourseDTO> findAll() {
		List<PaidCourseEntity> listEntity = paidCourseRepository.findAll();
		List<PaidCourseDTO> listDTO = new ArrayList<>();

		for (PaidCourseEntity itemEntity : listEntity) {
			
			
			PaidCourseDTO itemDTO = new PaidCourseDTO();
	
			itemDTO.setS3Path(itemEntity.getS3Path());;
			itemDTO.setName(itemEntity.getName());
			itemDTO.setDescription(itemEntity.getDescription());
			itemDTO.setTopic(itemEntity.getTopic());
			itemDTO.setThumbnail(itemEntity.getThumbnail());
			itemDTO.setSentiment(itemEntity.getSentiment());
			itemDTO.setShortDescription(itemEntity.getShortDescription());

			listDTO.add(itemDTO);
			
			
			
		}

		return listDTO;
	}

}
