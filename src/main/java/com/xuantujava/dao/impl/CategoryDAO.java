package com.xuantujava.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.stereotype.Repository;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;
import com.xuantujava.dao.ICategoryDAO;
import com.xuantujava.mapper.CategoryMapper;
import com.xuantujava.mapper.IRowMapper;
import com.xuantujava.model.CategoryModel;


@Repository
public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	
	
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";	
		return query(sql, new CategoryMapper());
	}
	
	
}
