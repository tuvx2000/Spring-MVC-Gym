package com.xuantujava.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.service.impl.FreeCourseService;

@Controller(value ="freecourseControllerOfWeb")
public class FreeCourseController {
	
	@Autowired
	private FreeCourseService freeCourseService;
	
	@RequestMapping(value = "/danh-sach-bai-hoc-mien-phi", method = RequestMethod.GET)
	public ModelAndView registrationPage(HttpServletRequest request, HttpServletResponse response) {

		List<FreeCourseDTO> listFreeCourse =  freeCourseService.findAll();
		
		FreeCourseDTO centerDTO = new FreeCourseDTO();
		centerDTO.setListResult(listFreeCourse);

		ModelAndView mav = new ModelAndView("web/freeCourse");

		mav.addObject("model", centerDTO);


		return mav;
	}

}
