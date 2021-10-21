package com.xuantujava.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.service.IPaidCourseService;
import com.xuantujava.service.impl.FreeCourseService;

@Controller(value ="paidCourseControllerOfWeb")
public class PaidCourseController {
	
	@Autowired
	private IPaidCourseService paidCourseService;
	
	@RequestMapping(value = "/danh-sach-bai-hoc-tra-phi", method = RequestMethod.GET)
	public ModelAndView listPaidCoursePage() {

		List<PaidCourseDTO> listPaidCourse =  paidCourseService.findAll();
//		
		
		System.out.println(listPaidCourse.size());
		PaidCourseDTO centerDTO = new PaidCourseDTO();
		centerDTO.setListResult(listPaidCourse);

		ModelAndView mav = new ModelAndView("web/paidCourse");

		mav.addObject("model", centerDTO);

//		freeCourseService.UpdateVideoSentimentAll();
		
		
		
		return mav;
	}

}
