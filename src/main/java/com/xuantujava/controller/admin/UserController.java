package com.xuantujava.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.DTO.UserDTO;
import com.xuantujava.service.ICommentService;
import com.xuantujava.service.IUserService;
import com.xuantujava.util.MessageUtil;

@Controller(value ="userControllerOfAdmin")
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/nguoi-dung/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		UserDTO model = new UserDTO();
		Pageable pageable = new PageRequest(page -1, limit);
		ModelAndView mav = new ModelAndView("admin/user/list");

		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messageResponse", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		
		model.setPage(page);
		model.setLimit(limit);
		
		
		model.setTotalItem(userService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		model.setListResult(userService.findAll(pageable));
		
		
		
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/nguoi-dung/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserDTO model = new UserDTO();
		if (id != null) {
			model = userService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messageResponse", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		model.setPassword("");
		mav.addObject("model", model);
		return mav;
	
	}
	
	
	
	
}
