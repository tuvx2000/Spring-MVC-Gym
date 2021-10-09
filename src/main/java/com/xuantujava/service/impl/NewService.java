package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.entity.NewEntity;
import com.xuantujava.model.NewsModel;
import com.xuantujava.repository.NewRepository;
import com.xuantujava.service.INewService;
@Service
public class NewService implements INewService{

	@Autowired
	NewRepository newRepository;
	
	@Override
	public List<NewEntity> findAll() {
		return newRepository.findAll();
	}
	
	



}

