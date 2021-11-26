package com.xuantujava.api.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.service.IFreeCourseService;
import com.xuantujava.service.IPaidCourseService;
import com.xuantujava.service.ISentimentService;

@RestController(value = "sentimentAPIOfAdmin")
public class SentimentAPI {

	@Autowired
	ISentimentService sentimentService;
	
	@Autowired
	private IPaidCourseService paidCourseService;
	
	@Autowired
	private IFreeCourseService freeCourseService;
	
	@PostMapping("/api/admin_sentiment")
	public String returnAnalyze(@RequestBody String userComment) {
		System.out.println("PARAM API: " + userComment); 
		String comment = userComment.substring(16,userComment.length()-2);
		
//		SentimentService
		
		String x = sentimentService.AnalyzedOneLineFinal(comment);
		
		
		
		return "{\"userSentiment\": \""+ x +"\"}";
	}
	
	@PostMapping("/api/admin_sentiment_freecourses")
	public String returnAnalyzex(@RequestBody String webparam) {
		System.out.println("PARAM API: " + webparam); 
		
		freeCourseService.UpdateVideoSentimentAll();

		String x = "succeed"; 
		return "{\"userSentiment\": \""+ x +"\"}";

	}
	
	
	@PostMapping("/api/admin_sentiment_paidcourses")
	public String returnAnalyzexx(@RequestBody String webparam) {
		System.out.println("PARAM API: " + webparam); 


		paidCourseService.UpdateVideoSentimentAll();
		
		
		
		return "{\"userSentiment\": \""+ "updateed" +"\"}";
	}
	
	
}
