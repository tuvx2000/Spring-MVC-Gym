package com.xuantujava.service;

import java.util.List;



import com.xuantujava.dao.INewDAO;
import com.xuantujava.model.CategoryModel;
import com.xuantujava.model.NewsModel;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);
}
