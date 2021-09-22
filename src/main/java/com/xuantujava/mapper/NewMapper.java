package com.xuantujava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.xuantujava.model.NewsModel;

public class NewMapper implements IRowMapper<NewsModel>{

	@Override
	public NewsModel mapRow(ResultSet resultset) {

		try {
			NewsModel news = new NewsModel();
			news.setId(resultset.getLong("id"));
			news.setTitle(resultset.getString("title"));
			return news;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

}
