package com.xuantujava.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.model.NewsModel;
import com.xuantujava.service.ICategoryService;
import com.xuantujava.service.INewService;

@Controller(value ="homeControllerOfWeb")
public class HomeController {

	@Autowired

	ICategoryService categoryService;
	
	@Autowired

	INewService newService;


	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		
		String title = "bai viet so 5";
		String content ="bai viet so 5";
		Long categoryId = 1L;	
		
		NewsModel newsModel = new NewsModel();
		newsModel.setTitle(title);
		newsModel.setContent(content);
		newsModel.setCategoryId(categoryId);
		//newService.save(newsModel);

		request.setAttribute("model",newsModel);
		
		


		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}
	
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {



		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

}


