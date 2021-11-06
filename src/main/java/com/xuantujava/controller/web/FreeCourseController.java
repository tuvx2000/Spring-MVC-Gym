package com.xuantujava.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.service.IFreeCourseService;

@Controller(value ="freecourseControllerOfWeb")
public class FreeCourseController {
	
	@Autowired
	private IFreeCourseService freeCourseService;
	
	@RequestMapping(value = "/danh-sach-bai-hoc-mien-phi", method = RequestMethod.GET)
	public ModelAndView registrationPage(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("hello");
		
		List<FreeCourseDTO> listFreeCourse =  freeCourseService.findAll();
		
		FreeCourseDTO centerDTO = new FreeCourseDTO();
		centerDTO.setListResult(listFreeCourse);

		ModelAndView mav = new ModelAndView("web/freeCourse");

		mav.addObject("model", centerDTO);

//		freeCourseService.UpdateVideoSentimentAll();
		
		return mav;
	}

}
