package com.xuantujava.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xuantujava.dao.ICategoryDAO;
import com.xuantujava.mapper.CategoryMapper;
import com.xuantujava.model.CategoryModel;


@Repository
public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	
	
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";	
		return query(sql, new CategoryMapper());
	}
	
	
}
