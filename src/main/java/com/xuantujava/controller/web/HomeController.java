package com.xuantujava.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registrationPage() {

		ModelAndView mav = new ModelAndView("registration");
		return mav;
	}
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		ModelAndView mav = new ModelAndView("redirect:/trang-chu");
		return mav;
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {

		ModelAndView mav = new ModelAndView("redirect:/dang-nhap?accessDenied");
		return mav;
	}

}


