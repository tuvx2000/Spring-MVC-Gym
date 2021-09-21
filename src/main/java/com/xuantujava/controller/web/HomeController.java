package com.xuantujava.controller.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.model.CategoryModel;
import com.xuantujava.model.UserModel;
import com.xuantujava.service.ICategoryService;
import com.xuantujava.service.impl.CategoryService;

@Controller(value ="homeControllerOfWeb")
public class HomeController {

	

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		
		//CategoryService CategoryService = new CategoryService();
		
		//request.setAttribute("categories",CategoryService.findAll());
		
		
		Connection x;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/xuantudbspringmvc?";
			String user = "root";
			String password = "xuantudb";
			x = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			x = null; 
		}
		
		String sql = "SELECT * FROM category";

		
		
		PreparedStatement statement = null;
		ResultSet resultset = null;		
		Connection connection = x;
		List<CategoryModel> results = new ArrayList<>();

		
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

			} catch (SQLException e) {
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
		
		
		
		
		
		
		UserModel userModel = new UserModel();
		userModel.setFullName(results.get(1).getName().toString());
		request.setAttribute("model",userModel);
		
		


		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}

}


