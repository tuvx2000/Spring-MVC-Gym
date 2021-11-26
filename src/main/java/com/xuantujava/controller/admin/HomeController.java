package com.xuantujava.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.service.IFreeCourseService;
import com.xuantujava.service.IPaidCourseService;
import com.xuantujava.util.LivestrymUtil;

@Controller(value ="homeControllerOfAdmin")
public class HomeController {

	@Autowired
	IFreeCourseService freeCourseService;
	
	@Autowired
	IPaidCourseService paidCourseService;	
	
	@RequestMapping(value = "/quan-tri/chatcreate", method = RequestMethod.GET)
	public ModelAndView homePagexx(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("chat/audio");	
		return mav;
	}
	
//	@RequestMapping(value = "/quan-tri/chat", method = RequestMethod.GET)
//	public ModelAndView homePagex(HttpServletRequest request) {
//		ModelAndView mav = new ModelAndView("chat/admin-home");
//		
//		mav.addObject("linkvideo",LivestrymUtil.getLinkvideo());			
//		return mav;
//	}
	
	@RequestMapping(value = "/quan-tri/chat", method = RequestMethod.POST)
	public ModelAndView homePagecreate(HttpServletRequest request) {
		
		
		ModelAndView mav = new ModelAndView("chat/admin-home");
		LivestrymUtil
			.setLinkvideo(request.getParameter("linkvideo"));
		LivestrymUtil.setStatusLivestrym(1);
		
		mav.addObject("linkvideo", LivestrymUtil.getLinkvideo());

		return mav;
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	/////

	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		
		List<Integer> listSentiment = freeCourseService.getChartSentimentOverall();

		List<Integer> listPaidSentiment = paidCourseService.getChartSentimentOverall();

		mav.addObject("NEGATIVE", listSentiment.get(0));
		mav.addObject("NEUTRAL", listSentiment.get(1));
		mav.addObject("POSITIVE", listSentiment.get(2));
		
		
//		System.out.println("================");
//
//		System.out.println("a " + listPaidSentiment.get(0));
//		System.out.println("b " + listPaidSentiment.get(1));
//		System.out.println("c " + listPaidSentiment.get(2));
		
		

		mav.addObject("NEGATIVE1", listPaidSentiment.get(0));
		mav.addObject("NEUTRAL1", listPaidSentiment.get(1));
		mav.addObject("POSITIVE1", listPaidSentiment.get(2));		
		
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/quan-tri/trang-chuxxxx", method = RequestMethod.GET)
	public ModelAndView homePagex() {
		ModelAndView mav = new ModelAndView("admin/xxxxx");
		
		
		return mav;
	}


}
