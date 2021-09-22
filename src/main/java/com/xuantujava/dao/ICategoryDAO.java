package com.xuantujava.dao;

import java.util.List;

import com.xuantujava.model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{

	List<CategoryModel> findAll();

}
