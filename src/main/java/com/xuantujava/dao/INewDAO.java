package com.xuantujava.dao;

import java.util.List;

import com.xuantujava.model.NewsModel;

public interface INewDAO extends IGenericDAO<NewsModel>{
	List<NewsModel> findAll();
}
