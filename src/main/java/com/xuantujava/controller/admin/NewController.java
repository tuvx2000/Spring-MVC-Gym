package com.xuantujava.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.model.NewsModel;
import com.xuantujava.service.INewService;

@Controller(value ="newControllerOfAdmin")
public class NewController {
	
	@Autowired
	private INewService newService;

	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		NewDTO model = new NewDTO();

		
		model.setPage(page);
		model.setLimit(limit);
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		
		
		ModelAndView mav = new ModelAndView("admin/new/list");
		Pageable pageable = new PageRequest(page -1, limit);
		
		model.setListResult(newService.findAll(pageable));
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew() {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		return mav;
	}

}
