package com.xuantujava.service.impl;

import java.util.List;

////comprehened imports
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;

///end ////comprehened imports
public class AwsComprehenedService {
	
    public static void main(String[] args) {
    	String sentimentComment = AnalyzedOneLineFinal("Wy85Th3Myws").toString();
    	
    	System.out.println(sentimentComment);
    	
        }

	public static DetectSentimentResult AnalyzedOneLine(String inputLine) {

		// start comprehened

		String text = inputLine;

		AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();

		AmazonComprehend comprehendClient = AmazonComprehendClientBuilder.standard().withCredentials(awsCreds)
				.withRegion("ap-northeast-1").build();

		// Call detectSentiment API
//		System.out.println("Calling DetectSentiment");
		DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest().withText(text)
				.withLanguageCode("en");
		DetectSentimentResult detectSentimentResult = comprehendClient.detectSentiment(detectSentimentRequest);
//		System.out.println(detectSentimentResult);
//		System.out.println("End of DetectSentiment\n");
//		System.out.println("Done");

		////// end

		return detectSentimentResult;
	}
	
	public static String AnalyzedOneLineFinal(String inputLine) {
		
		DetectSentimentResult detectSentimentResult = AnalyzedOneLine(inputLine);
		
		return detectSentimentResult.getSentiment();
	}
}
