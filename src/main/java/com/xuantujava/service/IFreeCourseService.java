package com.xuantujava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.NewDTO;

public interface IFreeCourseService {
	List<FreeCourseDTO> findAll();
	public void UpdateVideoSentimentAll();
	int getTotalItem();
	List<FreeCourseDTO> findAll(Pageable pageable);
	
	FreeCourseDTO save(FreeCourseDTO dto);
	void delete(long[] ids);
	FreeCourseDTO findById(long id);
	List<Integer> getChartSentimentOverall();

}
