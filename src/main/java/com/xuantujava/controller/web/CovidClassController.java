	package com.xuantujava.controller.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.dao.ICategoryDAO;
import com.xuantujava.dao.impl.CategoryDAO;
import com.xuantujava.model.UserModel;
import com.xuantujava.service.ICategoryService;
import com.xuantujava.service.INewService;


@Controller(value ="covidclassControllerOfWeb")
public class CovidClassController {

	
	@Autowired
	ICategoryService categoryService;
	
	@Autowired
	INewService newService;



	@RequestMapping(value = "/covid-class", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		Long categoryId = 1L; 
		
		
		//start static parameter
		UserModel userModel = new UserModel();
		userModel.setFullName("Vo Xuan Tu");
		request.setAttribute("model",userModel);
		// end static parameter

		request.setAttribute("categories",categoryService.findAll());
		request.setAttribute("model1",newService.findAll().get(1).getTitle());


		ModelAndView mav = new ModelAndView("web/covidClass");
		return mav;
	}
	
}
