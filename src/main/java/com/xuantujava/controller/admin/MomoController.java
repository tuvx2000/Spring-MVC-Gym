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
import com.xuantujava.DTO.TransactionDTO;
import com.xuantujava.service.ICommentService;
import com.xuantujava.service.ITransactionService;

@Controller(value ="momoControllerOfAdmin")
public class MomoController {
	
	@Autowired
	ITransactionService transactionService;
	
	
	@RequestMapping(value = "/quan-tri/momo", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		TransactionDTO model = new TransactionDTO();
		Pageable pageable = new PageRequest(page -1, limit);
		ModelAndView mav = new ModelAndView("admin/momo/list");


		
		model.setPage(page);
		model.setLimit(limit);
		
		
		model.setTotalItem(transactionService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		model.setListResult(transactionService.findAll(pageable));
		
		
		
		mav.addObject("model", model);
		
		mav.addObject("amountTransaction", transactionService.getSumTransaction());
		return mav;
	}
	
}
