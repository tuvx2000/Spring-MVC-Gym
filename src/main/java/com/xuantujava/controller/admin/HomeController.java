package com.xuantujava.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.service.IFreeCourseService;

@Controller(value ="homeControllerOfAdmin")
public class HomeController {

	@Autowired
	IFreeCourseService freeCourseService;

	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		
		List<Integer> listSentiment = freeCourseService.getChartSentimentOverall();
		
		mav.addObject("POSITIVE", listSentiment.get(0));
		mav.addObject("NEUTRAL", listSentiment.get(1));
		mav.addObject("NEGATIVE", listSentiment.get(2));

		
		
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/quan-tri/trang-chuxxxx", method = RequestMethod.GET)
	public ModelAndView homePagex() {
		ModelAndView mav = new ModelAndView("admin/xxxxx");
		
		
		return mav;
	}


}
