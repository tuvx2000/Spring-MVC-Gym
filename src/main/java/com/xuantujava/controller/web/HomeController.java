package com.xuantujava.controller.web;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.UserDTO;
import com.xuantujava.entity.CommentEntity;
import com.xuantujava.service.ICommentService;
import com.xuantujava.service.IUserService;
import com.xuantujava.service.impl.ManagementGoogleUserService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	IUserService userService;
	
	@Autowired
	ICommentService commentService;

	@Autowired
	ManagementGoogleUserService managementGoogleUserService;

	///////////////////////////////////////////////////////////////////////////////////////////comment


	
	@RequestMapping(value = "/post-binh-luan", method = RequestMethod.POST)
	public ModelAndView PostComment(HttpServletRequest request, HttpServletResponse response) {

//		request = managementGoogleUserService.GoogleSignInAndRegister(request, response);
//
//		ModelAndView mav = new ModelAndView("GoogleLogingOnLoading");
		System.out.println("yhhhhh yeahhhh");
		
		Long userId = userService.findUserIdByUserName(request.getParameter("userName"));
		
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setUserName(request.getParameter("userName"));
		commentDTO.setUserid(userId);
		commentDTO.setParentIDCOMMENT(Long.parseLong(request.getParameter("parentIDCOMMENT")));
		commentDTO.setCourseid(Long.parseLong(request.getParameter("courseid")));
		commentDTO.setComment(request.getParameter("comment"));

		System.out.println("user name:" +commentDTO.getUserName());
		System.out.println("parrent id:" +commentDTO.getParentIDCOMMENT());
		System.out.println("course id:" +commentDTO.getCourseid());
		System.out.println("comment string:" + commentDTO.getComment());	
	
		
		commentService.addComment(commentDTO);
		

		ModelAndView mav = new ModelAndView("redirect:/bai-hoc-tra-phi?courseid="+ commentDTO.getCourseid());


		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////// google sign-in

	@RequestMapping(value = "/google-dang-nhap", method = RequestMethod.POST)
	public ModelAndView googleSignInPage(HttpServletRequest request, HttpServletResponse response)
			throws GeneralSecurityException, IOException {

		request = managementGoogleUserService.GoogleSignInAndRegister(request, response);

		ModelAndView mav = new ModelAndView("GoogleLogingOnLoading");

		return mav;
	}
	/////////////////////////////////////////////////////

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {

	

		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			ModelAndView mav = new ModelAndView("redirect:/trang-chu");
			return mav;
		}

		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registrationPage(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			ModelAndView mav = new ModelAndView("redirect:/trang-chu");
			return mav;
		}

		ModelAndView mav = new ModelAndView("registration");
		return mav;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView registrationProcess(HttpServletRequest request) {

		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(request.getParameter("j_username"));
		userDTO.setPassword(request.getParameter("j_password"));
		userDTO.setFullName(request.getParameter("j_fullname"));

		userService.RegisterNewUser(userDTO);

		ModelAndView mav = new ModelAndView("redirect:/dang-nhap");
		return mav;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		ModelAndView mav = new ModelAndView("redirect:/trang-chu");
		return mav;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {

		ModelAndView mav = new ModelAndView("redirect:/dang-nhap?accessDenied");
		return mav;
	}

}
