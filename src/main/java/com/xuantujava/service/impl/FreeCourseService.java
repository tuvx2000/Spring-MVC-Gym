package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.entity.FreeCourseEntity;
import com.xuantujava.entity.UserEntity;
import com.xuantujava.repository.FreeCourseRepository;
import com.xuantujava.repository.UserRepository;
import com.xuantujava.service.IFreeCourseService;

@Service
public class FreeCourseService implements IFreeCourseService {

	@Autowired
	FreeCourseRepository freeCourseRepository;


	@Override
	public List<FreeCourseDTO> findAll() {

		List<FreeCourseEntity> listEntity = freeCourseRepository.findAll();
		List<FreeCourseDTO> listDTO = new ArrayList<>();

		for (FreeCourseEntity itemEntity : listEntity) {
			FreeCourseDTO itemDTO = new FreeCourseDTO();

			String videoId = GetVideoYoutubeId(itemEntity.getLinkyoutube());

			itemDTO.setLinkyoutube(videoId);
			itemDTO.setName(itemEntity.getName());
			itemDTO.setDescription(itemEntity.getDescription());
			itemDTO.setTopic(itemEntity.getTopic());
			itemDTO.setThumbnail(itemEntity.getThumbnail());
			itemDTO.setSentiment(itemEntity.getSentiment());

			listDTO.add(itemDTO);
		}

		return listDTO;
	}

	public void UpdateVideoSentimentAll() {
		List<FreeCourseEntity> listEntity = freeCourseRepository.findAll();
		
		for (FreeCourseEntity itemEntity : listEntity) {
			UpdateVideoSentiment(itemEntity.getLinkyoutube());
		}

	}
	

    
    

	public void UpdateVideoSentiment(String videoLink) {

		List<String> sentimentResult = new ArrayList<>();
		List<String> listComments = YoutubeService.GetCommentsYoutube(GetVideoYoutubeId(videoLink));
//		System.out.println(listComments);
		
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

		
//	    System.out.println(freeCourseRepository.findOneByLinkyoutube("https://www.youtube.com/watch?v=Wy85Th3Myws").getName());
//		System.out.println("x"+ countPositive + "x" +countNeutral+ "x" +countNegative);
	    
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
	
	
	


}
