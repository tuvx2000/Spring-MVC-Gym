package com.xuantujava.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xuantujava.dao.testDAO;
import com.xuantujava.mapper.NewMapper;
import com.xuantujava.model.NewsModel;

@Repository
public class testDAOclass extends AbstractDAO<NewsModel> implements testDAO {


	@Override
	public List<NewsModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM new");
		return query(sql.toString(), new NewMapper());
	}
}
