package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.converter.PaidCourseConverter;
import com.xuantujava.entity.CategoryEntity;
import com.xuantujava.entity.CommentEntity;
import com.xuantujava.entity.FreeCourseEntity;
import com.xuantujava.entity.NewEntity;
import com.xuantujava.entity.PaidCourseEntity;
import com.xuantujava.repository.CommentRepository;
import com.xuantujava.repository.PaidCourseRepository;
import com.xuantujava.service.ICommentService;
import com.xuantujava.service.IPaidCourseService;
import com.xuantujava.service.ISentimentService;

@Service
public class PaidCourseService implements IPaidCourseService{
	@Autowired
	PaidCourseRepository paidCourseRepository;
	
	@Autowired
	PaidCourseConverter paidCourseConverter;
	
	@Autowired
	ICommentService commentService;
	
	@Autowired
	ISentimentService sentimentService;
	
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
	public PaidCourseDTO save(PaidCourseDTO dto) {
		
		PaidCourseEntity paidCourseEntity = new PaidCourseEntity();
		if (dto.getId() != null) {
			PaidCourseEntity oldPaidCourse = paidCourseRepository.findOne(dto.getId());
			paidCourseEntity = paidCourseConverter.toEntity(oldPaidCourse, dto);
		} else {
			paidCourseEntity = paidCourseConverter.toEntity(dto);
		}
		
		return paidCourseConverter.toDto(paidCourseRepository.save(paidCourseEntity));
		
		
		
//		
//		
//		PaidCourseEntity oldNew = paidCourseRepository.findOne(PaidCourseDTO.getId());
//		paidCourseRepository.save(oldNew);
//		
		
		
		
		
		
		
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
		courseDTO.setSentiment(courseEntity.getSentiment());
//		System.out.println("Sentiment PaidService: "+courseEntity.getSentiment());
		return courseDTO;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) paidCourseRepository.count();
	}

	@Override
	public List<PaidCourseDTO> findAll(Pageable pageable) {
		List<PaidCourseDTO> models = new ArrayList<>();
		List<PaidCourseEntity> entities = paidCourseRepository.findAll(pageable).getContent();
		for (PaidCourseEntity item: entities) {
			PaidCourseDTO freeCourseDTO = paidCourseConverter.toDto(item);
			models.add(freeCourseDTO);
		}
		return models;
	}
	
	
	
	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			paidCourseRepository.delete(id);
		}
	}

	@Override
	public PaidCourseDTO findById(Long id) {
		// TODO Auto-generated method stub
		return findOne(id);
	}

	@Override
	public void UpdateVideoSentimentAll() {
//		UpdateVideoSentiment(1L)	;	
		List<PaidCourseEntity> listEntity = paidCourseRepository.findAll();
		
		
		for (PaidCourseEntity itemEntity : listEntity) {
			UpdateVideoSentiment(itemEntity.getId());
		}
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

	
	@Transactional
	public void UpdateVideoSentiment(long courseId) {

		List<String> sentimentResult = new ArrayList<>();
		List<String> listComments = commentService.findCommentsByCoursesId(courseId);

		int countPositive = 0,countNeutral = 0,countNegative = 0;
		String finalSentiment = "";
		
		
		
		for (String comment : listComments) {
			String statusComment = sentimentService.AnalyzedOneLineFinal(comment).toString();

			if(statusComment.equals("POSITIVE")) 
				countPositive++;
			else if ( statusComment.equals("NEUTRAL"))
				countNeutral++;
			else
				countNegative++;
		}
		
	    if (countPositive >= countNeutral && countPositive>= countNegative)
	    	finalSentiment = "POSITIVE";
	    else if (countNeutral >= countPositive && countNeutral>= countNegative)
	    	finalSentiment = "NEUTRAL";
	    else
	    	finalSentiment = "NEGATIVE";

		

	    
	    PaidCourseEntity itemPrepareForUpdate = paidCourseRepository.findOne(courseId);
	    
	    itemPrepareForUpdate.setSentiment(finalSentiment); 
	    
	    paidCourseRepository.save(itemPrepareForUpdate);
	    
	}

	@Override
	public List<Integer> getChartSentimentOverall() {
		List<Integer> listSentiment = new ArrayList<>();
		List<PaidCourseEntity> listEntity = paidCourseRepository.findAll();
		int a=0,b=0,c=0;
		for (PaidCourseEntity paidCourseEntity : listEntity) {

			
			if (paidCourseEntity.getSentiment().equals("POSITIVE")) {
				a++;
			}else if (paidCourseEntity.getSentiment().equals("NEUTRAL")){
				b++;
			}else
				c++;
		}	
		listSentiment.add(a);
		listSentiment.add(b);
		listSentiment.add(c);

		
		return listSentiment;
	}
	
	
	
}
