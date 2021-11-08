package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.converter.FreeCourseConverter;
import com.xuantujava.entity.CategoryEntity;
import com.xuantujava.entity.FreeCourseEntity;
import com.xuantujava.entity.NewEntity;
import com.xuantujava.entity.UserEntity;
import com.xuantujava.repository.FreeCourseRepository;
import com.xuantujava.repository.UserRepository;
import com.xuantujava.service.IFreeCourseService;

@Service
public class FreeCourseService implements IFreeCourseService {

	@Autowired
	FreeCourseRepository freeCourseRepository;

	@Autowired
	FreeCourseConverter freeCourseConverter;
	
	@Override
	public List<FreeCourseDTO> findAll() {

		System.out.println("xxx findAll Free Course");
		
		
		
		List<FreeCourseEntity> listEntity = freeCourseRepository.findAll();
		List<FreeCourseDTO> listDTO = new ArrayList<>();

		for (FreeCourseEntity itemEntity : listEntity) {
			FreeCourseDTO itemDTO = freeCourseConverter.toDto(itemEntity);
				
			itemDTO.setLinkyoutube(GetVideoYoutubeId(itemEntity.getLinkyoutube()));

//			String videoId = GetVideoYoutubeId(itemEntity.getLinkyoutube());
//
//			itemDTO.setLinkyoutube(videoId);
//			itemDTO.setName(itemEntity.getName());
//			itemDTO.setDescription(itemEntity.getDescription());
//			itemDTO.setTopic(itemEntity.getTopic());
//			itemDTO.setThumbnail(itemEntity.getThumbnail());
//			itemDTO.setSentiment(itemEntity.getSentiment());
			System.out.println("link: " + itemDTO.getLinkyoutube());
			listDTO.add(itemDTO);
		}

		return listDTO;
	}

	@Override
	@Transactional
	public void UpdateVideoSentimentAll() {
		List<FreeCourseEntity> listEntity = freeCourseRepository.findAll();
		
		for (FreeCourseEntity itemEntity : listEntity) {
			UpdateVideoSentiment(itemEntity.getLinkyoutube());
		}

	}
	

    
    

	@Transactional
	public void UpdateVideoSentiment(String videoLink) {

		List<String> sentimentResult = new ArrayList<>();
		List<String> listComments = YoutubeService.GetCommentsYoutube(GetVideoYoutubeId(videoLink));
//		//System.out.println(listComments);
		
//		List<String> statusComment = new ArrayList<>();
//		statusComment.add("POSITIVE");
//		statusComment.add("NEUTRAL");
	//	statusComment.add("NEGATIVE");
		int countPositive = 0,countNeutral = 0,countNegative = 0;
		String finalSentiment = "";
		
		
		
		for (String comment : listComments) {
//			sentimentResult.add(AwsComprehenedService.AnalyzedOneLineFinal(comment));
			String statusComment = AwsComprehenedService.AnalyzedOneLineFinal(comment).toString();

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

		
//	    //System.out.println(freeCourseRepository.findOneByLinkyoutube("https://www.youtube.com/watch?v=Wy85Th3Myws").getName());
//		//System.out.println("x"+ countPositive + "x" +countNeutral+ "x" +countNegative);
	    
	    FreeCourseEntity itemPrepareForUpdate = freeCourseRepository.findOneByLinkyoutube(videoLink);
	    
	    itemPrepareForUpdate.setSentiment(finalSentiment); 
	    
	    freeCourseRepository.save(itemPrepareForUpdate);
	    
	}

	public String GetVideoYoutubeId(String rawLinkYoutube) {

		String[] parts = rawLinkYoutube.split("=");
		String part1 = parts[0]; // frefix
		String part2 = parts[1]; // videoId

		return part2;
	}

	@Override
	public int getTotalItem() {
		return (int) freeCourseRepository.count();
	}

	@Override
	public List<FreeCourseDTO> findAll(Pageable pageable) {
		List<FreeCourseDTO> models = new ArrayList<>();
		List<FreeCourseEntity> entities = freeCourseRepository.findAll(pageable).getContent();
		for (FreeCourseEntity item: entities) {
			FreeCourseDTO freeCourseDTO = freeCourseConverter.toDto(item);
			models.add(freeCourseDTO);
		}
		return models;
	}

	@Override
	@Transactional
	public FreeCourseDTO save(FreeCourseDTO dto) {

		FreeCourseEntity freeCourseEntity = new FreeCourseEntity();
		if (dto.getId() != null) {
			FreeCourseEntity oldCourse = freeCourseRepository.findOne(dto.getId());

			freeCourseEntity = freeCourseConverter.toEntity(oldCourse, dto);
		} else {
			freeCourseEntity = freeCourseConverter.toEntity(dto);
		}
		return freeCourseConverter.toDto(freeCourseRepository.save(freeCourseEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			freeCourseRepository.delete(id);
		}
	}

	@Override
	public FreeCourseDTO findById(long id) {
		FreeCourseEntity entity = freeCourseRepository.findOne(id);
		return freeCourseConverter.toDto(entity);
	}
	
	
	@Override
	public List<Integer> getChartSentimentOverall() {
		List<Integer> listSentiment = new ArrayList<>();
		List<FreeCourseEntity> listEntity = freeCourseRepository.findAll();
		int a=0,b=0,c=0;
		
		for (FreeCourseEntity freeCourseEntity : listEntity) {
			if (freeCourseEntity.getSentiment().equals("POSITIVE")) {
				a++;
			}else if (freeCourseEntity.getSentiment().equals("NEUTRAL")){
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
