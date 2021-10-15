package com.xuantujava.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value ="courseControllerOfAdmin")
public class CourseController {

	
	@RequestMapping(value = "/quan-tri/bai-hoc/them-moi", method = RequestMethod.GET)
	public ModelAndView editNew() {
		ModelAndView mav = new ModelAndView("admin/course/addItem");
		return mav;
	}
	
	
}
