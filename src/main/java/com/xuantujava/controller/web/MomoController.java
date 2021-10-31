	package com.xuantujava.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.UserDTO;
import com.xuantujava.Momo.allinone.AllInOne;
import com.xuantujava.repository.UserRepository;
import com.xuantujava.service.IUserService;




@Controller(value ="momoControllerOfWeb")
public class MomoController {

	@Autowired
	IUserService userService;
	
	@RequestMapping(value = "/mox", method = RequestMethod.GET)
	public ModelAndView homePagex(HttpServletRequest request) {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("NAME:"+ auth.getName());
		
		
		int statusPaid = userService.findUserStatusPaidByUserName(auth.getName().toString());
		if( statusPaid == 1) {
			ModelAndView mav = new ModelAndView("web/momo/momo2");
			return mav;
		}

		
		
		
		
		
		
		String userId = userService.findUserIdByUserName(auth.getName().toString()).toString();
		

		
		
		
		
//		System.out.println("xxxxxxxxx");
		String hold = AllInOne.dump(userId);
//		System.out.println("url:"+hold);
		
		
		
		
		ModelAndView mav = new ModelAndView("redirect:"+ hold);
		return mav;
	}
	
	
	

	@RequestMapping(value = "/momo1", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("NAME:"+ auth.getName());
		
		Long userId = userService.findUserIdByUserName(auth.getName().toString());
		
		System.out.println();
		
		
		
		
		
		System.out.println("1111111111");
		
		
		/////////////// Xu ly them nguoi dung da dang ky
		
		userService.updateStatusPaid(1, userId);
		
		ModelAndView mav = new ModelAndView("web/momo/momo1");
		return mav;
	}
	

	
	@PostMapping("/momo2")
	public ModelAndView homePage2(HttpServletRequest request, HttpServletResponse response) {


		
		System.out.println("22222222222");

		ModelAndView mav = new ModelAndView("web/momo/momo2");
		return mav;

	}
	@GetMapping("/momo2")
	public ModelAndView homePage22(HttpServletRequest request, HttpServletResponse response) {


		
		System.out.println("22222222222");

		ModelAndView mav = new ModelAndView("web/momo/momo2");
		return mav;

	}
	
}
