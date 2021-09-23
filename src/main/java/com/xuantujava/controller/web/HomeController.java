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
import com.xuantujava.service.INewService;
import com.xuantujava.service.impl.CategoryService;

@Controller(value ="homeControllerOfWeb")
public class HomeController {

	@Inject
	ICategoryService categoryService;
	


	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		
		//CategoryService CategoryService = new CategoryService();
		
		//request.setAttribute("categories",CategoryService.findAll());
		
		
		
		

		request.setAttribute("model",categoryService.findAll().get(1).getName().toString());
		
		


		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}

}


