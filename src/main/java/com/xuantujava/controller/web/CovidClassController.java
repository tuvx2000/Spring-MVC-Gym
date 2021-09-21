	package com.xuantujava.controller.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.model.UserModel;
import com.xuantujava.service.ICategoryService;

@Controller(value ="covidclassControllerOfWeb")
public class CovidClassController {

	
	@Inject
	ICategoryService CategoryService;


	@RequestMapping(value = "/covid-class", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		
		UserModel userModel = new UserModel();
		userModel.setFullName("Vo Xuan Tu");
		request.setAttribute("model",userModel);

		request.setAttribute("categories",CategoryService.findAll().get(1));

		ModelAndView mav = new ModelAndView("web/covidClass");
		return mav;
	}
	
}
