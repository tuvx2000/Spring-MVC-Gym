package com.xuantujava.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;
import com.xuantujava.dao.ICategoryDAO;
import com.xuantujava.model.CategoryModel;


@ManagedBean
public class CategoryDAO implements ICategoryDAO {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/xuantudbspringmvc?";
			String user = "root";
			String password = "xuantudb";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null; 
		}
		
 		
	}
	
	
	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<>();
		
		String sql = "SELECT * FROM category";
		
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultset = statement.executeQuery();
				
				while(resultset.next()){
					CategoryModel category = new CategoryModel();
					category.setId(resultset.getLong("id"));
					category.setCode(resultset.getString("code"));
					category.setName(resultset.getString("name"));
					results.add(category);
					}
				return results;

			} catch (SQLException e) {
				return null;
			} finally {
				try {
					connection.close();
					statement.close();
					resultset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
}
