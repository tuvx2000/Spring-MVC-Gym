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

import com.xuantujava.dao.INewDAO;
import com.xuantujava.mapper.NewMapper;
import com.xuantujava.model.CategoryModel;
import com.xuantujava.model.NewsModel;

@Repository
public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {


	@Override
	public List<NewsModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM new");
		return query(sql.toString(), new NewMapper());
	}
}
