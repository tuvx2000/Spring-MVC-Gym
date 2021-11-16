package com.xuantujava.controller.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.service.IFreeCourseService;

@Controller(value ="freecourseControllerOfWeb")
public class FreeCourseController {
	
	@Autowired
	private IFreeCourseService freeCourseService;
	
//	
//	@RequestMapping(value = "/danh-sach-bai-hoc-mien-phi", method = RequestMethod.GET)
//	public ModelAndView registrationPagex( HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView("web/freeCourse");
//		
////		System.out.println("hello");
//		int page = 1, limit =10;
//		
//		List<FreeCourseDTO> listFreeCourse =  freeCourseService.findAll();
//		
//		Pageable pageable = new PageRequest(page -1, limit);
//		FreeCourseDTO centerDTO = new FreeCourseDTO();
//
//		centerDTO.setPage(page);
//		centerDTO.setLimit(limit);
//		
//		System.out.println("page=" +page + "/ litmit=" + limit);
//		
//
//		centerDTO.setTotalItem(freeCourseService.getTotalItem());
//		centerDTO.setTotalPage((int) Math.ceil((double) centerDTO.getTotalItem() / centerDTO.getLimit()));
//		centerDTO.setListResult(freeCourseService.findAll(pageable));
//		
//	//	centerDTO.setListResult(listFreeCourse); list allllll
//
//
//		mav.addObject("model", centerDTO);
//
////		freeCourseService.UpdateVideoSentimentAll();
//		
//		return mav;
//	}
//	
//	
	
	
	@RequestMapping(value = "/danh-sach-bai-hoc-mien-phi", method = RequestMethod.GET)
	public ModelAndView registrationPage(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("web/freeCourse");
						
		
//		System.out.println("hello");
		
		List<FreeCourseDTO> listFreeCourse =  freeCourseService.findAll();
		
		Pageable pageable = new PageRequest(page -1, limit);
		FreeCourseDTO centerDTO = new FreeCourseDTO();

		centerDTO.setPage(page);
		centerDTO.setLimit(limit);
		
		System.out.println("page=" +page + "/ litmit=" + limit);
		

		centerDTO.setTotalItem(freeCourseService.getTotalItem());
		centerDTO.setTotalPage((int) Math.ceil((double) centerDTO.getTotalItem() / centerDTO.getLimit()));
		centerDTO.setListResult(freeCourseService.findAll(pageable));
		
	//	centerDTO.setListResult(listFreeCourse); list allllll


		mav.addObject("model", centerDTO);

//		freeCourseService.UpdateVideoSentimentAll();
		
		return mav;
	}

}
