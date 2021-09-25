package com.xuantujava.service.impl;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.dao.INewDAO;
import com.xuantujava.model.CategoryModel;
import com.xuantujava.model.NewsModel;
import com.xuantujava.service.INewService;
@Service
public class NewService implements INewService{
	
	@Autowired
	private INewDAO newDao;

	

	@Override
	public List<NewsModel> findAll() {
		return newDao.findAll();
	}	



}

