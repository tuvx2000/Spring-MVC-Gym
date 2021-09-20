 package com.xuantujava.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.xuantujava.dao.ICategoryDAO;
import com.xuantujava.dao.impl.CategoryDAO;
import com.xuantujava.model.CategoryModel;
import com.xuantujava.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDao;
	
//	public CategoryService() {
//		categoryDao = new CategoryDAO();
//	}
	
	@Override
	public List<CategoryModel> findAll() {
		
		return categoryDao.findAll();
	}
	
	

}
