package com.xuantujava.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value ="homeControllerOfWeb")
public class HomeController {

	
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		/*
		String title = "bai viet so 5";
		String content ="bai viet so 5";
		Long categoryId = 1L;	 
		NewsModel newsModel = new NewsModel();
		newsModel.setTitle(title);
		newsModel.setContent(content);
		newsModel.setCategoryId(categoryId);
		newService.save(newsModel);

		request.setAttribute("model",categoryService.findAll().get(1).getName().toString());
		*/
		


		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}

}


