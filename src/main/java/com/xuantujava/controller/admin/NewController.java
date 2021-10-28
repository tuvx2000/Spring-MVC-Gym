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

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.service.ICategoryService;
import com.xuantujava.service.INewService;
import com.xuantujava.util.MessageUtil;

@Controller(value ="newControllerOfAdmin")
public class NewController {
	
	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		NewDTO model = new NewDTO();
		Pageable pageable = new PageRequest(page -1, limit);

		
		model.setPage(page);
		model.setLimit(limit);
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		model.setListResult(newService.findAll(pageable));
		
		
		ModelAndView mav = new ModelAndView("admin/new/list");
		
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
//		System.out.println("Id bai viet: "+ id);
//		
//		
//		
//		
		ModelAndView mav = new ModelAndView("admin/new/edit");
		NewDTO model = new NewDTO();
		if (id != null) {
			model = newService.findById(id);
		}
//		if (request.getParameter("message") != null) {
//			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
//			mav.addObject("message", message.get("message"));
//			mav.addObject("alert", message.get("alert"));
//		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	
	}

}
