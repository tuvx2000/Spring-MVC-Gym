	package com.xuantujava.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

		ModelAndView mav = new ModelAndView("web/momo/momo1");
		return mav;
	}
	

	
	@PostMapping("/momo2")
	public ModelAndView homePage2(HttpServletRequest request, HttpServletResponse response) {


		
		System.out.println("22222222222");

		ModelAndView mav = new ModelAndView("web/momo/momo2");
		return mav;

	}
	@GetMapping("/momo2")
	public ModelAndView homePage22(HttpServletRequest request, HttpServletResponse response) {


		
		System.out.println("22222222222");

		ModelAndView mav = new ModelAndView("web/momo/momo2");
		return mav;

	}
	
}
