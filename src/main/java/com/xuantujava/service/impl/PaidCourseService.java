package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.entity.CategoryEntity;
import com.xuantujava.entity.NewEntity;
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
			itemDTO.setId(itemEntity.getId());
			listDTO.add(itemDTO);
			
			
			
		}

		return listDTO;
	}

	@Override
	public void save(PaidCourseDTO PaidCourseDTO) {
		PaidCourseEntity oldNew = paidCourseRepository.findOne(PaidCourseDTO.getId());
		paidCourseRepository.save(oldNew);
		
	}

	@Override
	public PaidCourseDTO findOne(Long courseId) {
		PaidCourseDTO courseDTO = new PaidCourseDTO();
		PaidCourseEntity courseEntity= paidCourseRepository.findOne(courseId);
		courseDTO.setId(courseEntity.getId());
		courseDTO.setS3Path(courseEntity.getS3Path());
		courseDTO.setTopic(courseEntity.getTopic());
		courseDTO.setThumbnail(courseEntity.getThumbnail());
		courseDTO.setName(courseEntity.getName());
		
		return courseDTO;
	}

//	@Override
//	public void save(PaidCourseDTO PaidCourseDTO) {
//		
//		PaidCourseEntity paidCourseEntity = new PaidCourseEntity();
//		if (PaidCourseDTO.getId() != null) {
//			PaidCourseEntity oldNew = paidCourseRepository.findOne(PaidCourseDTO.getId());
//
//			//System.out.println("need update PaidCourse/ Service");
//		} else {
//			paidCourseEntity.setCategory(category);
//			paidCourseEntity.setDescription(description);
//			paidCourseEntity.setS3Path(s3Path);
//			
//		}
//		return newConverter.toDto(newRepository.save(newEntity));
//	}
//	}

}
