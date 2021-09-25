 package com.xuantujava.service.impl;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuantujava.dao.ICategoryDAO;
import com.xuantujava.dao.impl.CategoryDAO;
import com.xuantujava.model.CategoryModel;
import com.xuantujava.service.ICategoryService;


@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDAO categoryDao;
	/*
	public CategoryService() {
		categoryDao = new CategoryDAO();
	}*/
	
	@Override
	public List<CategoryModel> findAll() {
		/// note
	//	CategoryDAO categoryDAO = new CategoryDAO();
		
		return categoryDao.findAll();
	}
	
	

}
