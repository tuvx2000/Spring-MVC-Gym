package com.xuantujava.dao;

import java.util.List;

import com.xuantujava.model.NewsModel;

public interface testDAO extends IGenericDAO<NewsModel>{
	List<NewsModel> findAll();

}
