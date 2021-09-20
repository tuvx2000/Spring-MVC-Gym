package com.xuantujava.controller.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Predicate;
import com.xuantujava.model.UserModel;
import com.xuantujava.service.ICategoryService;
import com.xuantujava.service.impl.CategoryService;

@Controller(value ="covidclassControllerOfWeb")
public class CovidClassController {
	
	@Inject
	private ICategoryService CategoryService;

	@RequestMapping(value = "/covid-class", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		
		
		//truyen static information
		UserModel userModel = new UserModel();
		userModel.setFullName("Vo Xuan Tu");
		request.setAttribute("model",userModel);
		
		
		//truyen dynamic information
		request.setAttribute("categories",CategoryService.findAll());



		
		ModelAndView mav = new ModelAndView("web/covidClass");
		return mav;
	}
	
}
