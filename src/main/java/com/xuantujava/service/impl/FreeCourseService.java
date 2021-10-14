package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.entity.FreeCourseEntity;
import com.xuantujava.repository.FreeCourseRepository;
import com.xuantujava.service.IFreeCourseService;

@Service
public class FreeCourseService implements IFreeCourseService{

	@Autowired
	FreeCourseRepository freeCourseRepository;
	
	@Override
	public List<FreeCourseDTO> findAll() {
		
		List<FreeCourseEntity> listEntity= freeCourseRepository.findAll();
		List<FreeCourseDTO> listDTO = new ArrayList<>();
		
		for(FreeCourseEntity itemEntity : listEntity) {
			FreeCourseDTO itemDTO = new FreeCourseDTO();
			
			String videoId = getVideoYoutubeId(itemEntity.getLinkyoutube());
			
			itemDTO.setLinkyoutube(videoId);
			itemDTO.setName(itemEntity.getName());
			itemDTO.setDescription(itemEntity.getDescription());
			itemDTO.setTopic(itemEntity.getTopic());
			itemDTO.setThumbnail(itemEntity.getThumbnail());
			
			listDTO.add(itemDTO);
		}

		return listDTO;
	}

	
	 String getVideoYoutubeId(String rawLinkYoutube) {
		

		String[] parts = rawLinkYoutube.split("=");
		String part1 = parts[0]; // frefix
		String part2 = parts[1]; // videoId
			
		return "HnoPHqrdXQ8";
	}
	
}
