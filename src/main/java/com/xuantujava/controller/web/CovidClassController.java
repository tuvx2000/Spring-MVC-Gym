	package com.xuantujava.controller.web;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.repository.UserRepository;




@Controller(value ="covidclassControllerOfWeb")
public class CovidClassController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/covid-class", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		Long categoryId = 1L; 
		
		
	

		ModelAndView mav = new ModelAndView("web/covidClass");
		return mav;
	}
	
}
