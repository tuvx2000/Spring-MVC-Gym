package com.xuantujava.service.impl;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.xuantujava.dao.INewDAO;
import com.xuantujava.model.CategoryModel;
import com.xuantujava.model.NewsModel;
import com.xuantujava.service.INewService;
@ManagedBean
public class NewService implements INewService{
	
	@Inject
	private INewDAO newDao;

	public List<NewsModel> findByCategoryId(Long categoryId) {
		
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		Long newId = newDao.save(newsModel);
		System.out.print(newId);
		return null;
	}



}
