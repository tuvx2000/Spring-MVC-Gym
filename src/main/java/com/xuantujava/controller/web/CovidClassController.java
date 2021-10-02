	package com.xuantujava.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller(value ="covidclassControllerOfWeb")
public class CovidClassController {

	


	@RequestMapping(value = "/covid-class", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		Long categoryId = 1L; 
		
		
		//start static parameter
		UserModel userModel = new UserModel();
		userModel.setFullName("Vo Xuan Tu");
		request.setAttribute("model",userModel);


		ModelAndView mav = new ModelAndView("web/covidClass");
		return mav;
	}
	
}
