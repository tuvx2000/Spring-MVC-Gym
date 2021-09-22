package com.xuantujava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.xuantujava.model.CategoryModel;
import com.xuantujava.model.NewsModel;

public class CategoryMapper implements IRowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet resultset) {

		try {
			CategoryModel category = new CategoryModel();			
			category.setId(resultset.getLong("id"));
			category.setCode(resultset.getString("code"));
			category.setName(resultset.getString("name"));
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}
	
}
