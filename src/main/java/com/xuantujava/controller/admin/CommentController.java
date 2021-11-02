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

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.service.ICommentService;
import com.xuantujava.util.MessageUtil;

@Controller(value ="commentControllerOfAdmin")
public class CommentController {
	
	@Autowired
	ICommentService commentService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/binh-luan/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		CommentDTO model = new CommentDTO();
		Pageable pageable = new PageRequest(page -1, limit);
		ModelAndView mav = new ModelAndView("admin/comment/list");

		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messageResponse", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		
		model.setPage(page);
		model.setLimit(limit);
		
		
		model.setTotalItem(commentService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		model.setListResult(commentService.findAll(pageable));
		
		
		
		mav.addObject("model", model);
		return mav;
	}
	
	
	
	
	
	@RequestMapping(value = "/quan-tri/binh-luan/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
//		//System.out.println("Id bai viet: "+ id);
//		
//		
//		
//		
		ModelAndView mav = new ModelAndView("admin/comment/edit");
		CommentDTO model = new CommentDTO();
		if (id != null) {
			model = commentService.findById(id);
			System.out.println("comment id: "+ id + " / " + model.getUserName());
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messageResponse", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	
	}
	
	
	
	
	
}
