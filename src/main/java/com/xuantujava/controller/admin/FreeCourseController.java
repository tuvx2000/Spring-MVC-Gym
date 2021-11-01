package com.xuantujava.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.converter.FreeCourseConverter;
import com.xuantujava.service.IFreeCourseService;
import com.xuantujava.util.MessageUtil;

@Controller(value ="freeCourseControllerOfAdmin")
public class FreeCourseController {
	@Autowired
	IFreeCourseService freeCourseService;
	
	@Autowired
	private MessageUtil messageUtil;
	

	
	@RequestMapping(value = "/quan-tri/bai-hoc-mien-phi/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		FreeCourseDTO model = new FreeCourseDTO();
		Pageable pageable = new PageRequest(page -1, limit);
		ModelAndView mav = new ModelAndView("admin/freeCourse/list");

		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messageResponse", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		
		model.setPage(page);
		model.setLimit(limit);
		
		
		model.setTotalItem(freeCourseService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		model.setListResult(freeCourseService.findAll(pageable));
		
		
		
		mav.addObject("model", model);
		return mav;
	}
}
