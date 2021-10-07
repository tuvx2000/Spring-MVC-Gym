package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.entity.NewEntity;
import com.xuantujava.model.NewsModel;
import com.xuantujava.repository.NewRepository;
import com.xuantujava.service.INewService;
@Service
public class NewService implements INewService{
	
	@Autowired
	private NewRepository newRepository;
	
	
//	@Autowired
//	private INewDAO newDao;
//
//	
//
	@Override
	public List<NewsModel> findAll() {
		
		
		List<NewEntity> entities = newRepository.findAll();
		
		List<NewsModel> results = new ArrayList<>();
		for (NewEntity item: entities) {
			NewsModel resul =  new NewsModel();
			resul.setTitle(item.getTitle());
			results.add(resul);
		}
		
		return results;
	}	



}

