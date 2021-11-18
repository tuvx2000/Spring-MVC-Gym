package com.xuantujava.api.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.NewDTO;

@RestController(value = "sentimentAPIOfAdmin")
public class SentimentAPI {

	@PostMapping("/api/admin_sentiment")
	public String returnAnalyze(@RequestBody String userComment) {
		System.out.println("PARAM API: " + userComment); 

		String x = "POSITIVE";
		return "{\"userSentiment\": \""+ x +"\"}";
	}
}
