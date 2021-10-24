	package com.xuantujava.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.repository.UserRepository;




@Controller(value ="momoControllerOfWeb")
public class MomoController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/momo1", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		
		
		
		
		System.out.println("1111111111");

		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}
	
	@RequestMapping(value = "/momo1", method = RequestMethod.GET)
	public ModelAndView homePage2(HttpServletRequest request) {


		
		System.out.println("22222222222");

		ModelAndView mav = new ModelAndView("web/home");
		return mav;

	}
	
}
