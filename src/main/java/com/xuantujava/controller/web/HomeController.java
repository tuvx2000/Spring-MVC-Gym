package com.xuantujava.controller.web;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xuantujava.DTO.MyUser;
import com.xuantujava.DTO.NewDTO;
import com.xuantujava.DTO.UserDTO;
import com.xuantujava.constant.SystemConstant;
import com.xuantujava.model.NewsModel;
import com.xuantujava.service.ICategoryService;
import com.xuantujava.service.INewService;
import com.xuantujava.service.IUserService;
import com.xuantujava.service.impl.ManagementGoogleUserService;

import io.netty.util.Constant;

////comprehened imports
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectDominantLanguageRequest;
import com.amazonaws.services.comprehend.model.DetectDominantLanguageResult;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
///end ////comprehened imports


////google SignIn
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;





@Controller(value ="homeControllerOfWeb")
public class HomeController {

	@Autowired
	ICategoryService categoryService;
	
	@Autowired
	INewService newService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	ManagementGoogleUserService managementGoogleUserService;
	
	
	///////////////////////////////////////////////////////////////////////////////////////////for comprehened
			@RequestMapping(value = "/comprehened", method = RequestMethod.GET)
			public ModelAndView comprehenedPage(HttpServletRequest request, HttpServletResponse response) {
				//start comprehened
				
				 String text = "oh my shiet!!!this cousse is wort";	
				
				 AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();
				 
			        AmazonComprehend comprehendClient =
			            AmazonComprehendClientBuilder.standard()
			                                         .withCredentials(awsCreds)
			                                         .withRegion("ap-northeast-1")
			                                         .build();
			                                         
			   // Call detectSentiment API
			        System.out.println("Calling DetectSentiment");
			        DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest().withText(text)
			                                                                                    .withLanguageCode("en");
			        DetectSentimentResult detectSentimentResult = comprehendClient.detectSentiment(detectSentimentRequest);
			        System.out.println(detectSentimentResult);
			        System.out.println("End of DetectSentiment\n");
			        System.out.println( "Done" );
				
				////// end
				
				NewsModel newsModel = new NewsModel();
				newsModel.setTitle(detectSentimentResult.toString());

				request.setAttribute("model1",newsModel);
				
				
				
				
				ModelAndView mav = new ModelAndView("web/home");
				return mav;
				}	
	
	
	//////////////////////////////////////////////////////////////// google sign-in

	@RequestMapping(value = "/google-dang-nhap", method = RequestMethod.POST)
	public ModelAndView googleSignInPage(HttpServletRequest request, HttpServletResponse response) throws GeneralSecurityException, IOException {

		request = managementGoogleUserService.GoogleSignInAndRegister(request,response);
		
		ModelAndView mav = new ModelAndView("GoogleLogingOnLoading");
		
		return mav;
	}
	/////////////////////////////////////////////////////


	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		
		String title = "bai viet so 5";
		String content ="bai viet so 5";
		Long categoryId = 1L;	
		
		NewsModel newsModel = new NewsModel();
		newsModel.setTitle(request.getParameter("googleSignIn")+request.getParameter("googleSignIn1"));
		newsModel.setContent(content);
		newsModel.setCategoryId(categoryId);
		String x = request.getParameter("googleSignIn")+request.getParameter("googleSignIn1");
		//newService.save(newsModel);
		request.setAttribute("model",newsModel);
		
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( !(auth instanceof AnonymousAuthenticationToken) ) {
			ModelAndView mav = new ModelAndView("redirect:/trang-chu");
			return mav;
		}	
		
		
		
		
		

		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registrationPage(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( !(auth instanceof AnonymousAuthenticationToken) ) {
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
		if( auth != null) {
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


