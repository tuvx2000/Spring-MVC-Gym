package com.xuantujava.dao;

import java.util.List;

import com.xuantujava.model.NewsModel;
import com.xuantujava.paging.Pageble;

public interface INewDAO extends GenericDAO<NewsModel> {
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newModel);
	void update(NewsModel updateNew);
	void delete(long id);
	List<NewsModel> findAll(Pageble pageble);
	int getTotalItem();
}
