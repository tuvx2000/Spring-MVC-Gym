package com.xuantujava.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.service.ICommentService;
import com.xuantujava.service.IPaidCourseService;
import com.xuantujava.service.IUserService;
import com.xuantujava.service.impl.FreeCourseService;

@Controller(value ="paidCourseControllerOfWeb")
public class PaidCourseController {
	@Autowired
	IUserService userService;
	
	@Autowired
	ICommentService commentService;
	
	@Autowired
	private IPaidCourseService paidCourseService;
	
	@RequestMapping(value = "/danh-sach-bai-hoc-tra-phi", method = RequestMethod.GET)
	public ModelAndView listPaidCoursePage() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("NAME:"+ auth.getName());
		
		
		int statusPaid = userService.findUserStatusPaidByUserName(auth.getName().toString());
		if( statusPaid != 1) {
			
			ModelAndView mav = new ModelAndView("web/momo/momo2");
			mav.addObject("textStatus","Please Make Member to Watching Paid Courses");
			return mav;
		}
		
		
		
		

		List<PaidCourseDTO> listPaidCourse =  paidCourseService.findAll();
		
//		System.out.println(listPaidCourse.size());
		PaidCourseDTO centerDTO = new PaidCourseDTO();
		centerDTO.setListResult(listPaidCourse);
		ModelAndView mav = new ModelAndView("web/paidCourseMenu");
				
		mav.addObject("model", centerDTO);

//		freeCourseService.UpdateVideoSentimentAll();
		
		
		
		return mav;
	}
	
	@RequestMapping(value = "/bai-hoc-tra-phi", method = RequestMethod.GET)
	public ModelAndView paidCoursePage(@RequestParam("courseid") Long courseid) {

		ModelAndView mav = new ModelAndView("web/paidCourse");

		List<CommentDTO> listDTO = commentService.listCommentByCourseId(courseid);
		
		System.out.println("course-ID: " + courseid);
		
		CommentDTO model = new CommentDTO();;
		
		model.setListResult(listDTO);
		
		String s3Path = paidCourseService.findOne(courseid).getS3Path();
		String name = paidCourseService.findOne(courseid).getName();

		mav.addObject("name", name);
		mav.addObject("courseid", courseid);;
		mav.addObject("s3path", s3Path);;
		mav.addObject("model", model);


		return mav;
	}

}
