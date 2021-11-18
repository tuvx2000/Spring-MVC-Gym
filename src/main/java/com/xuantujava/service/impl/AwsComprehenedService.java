package com.xuantujava.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.xuantujava.service.ISentimentService;

///end ////comprehened imports
@Service
public class AwsComprehenedService implements ISentimentService{
	
//    public static void main(String[] args) throws FileNotFoundException {
//    	String sentimentComment = AnalyzedOneLineFinal("IT's so good").toString();
//    	
//    	System.out.println(sentimentComment);
//
//        }



	public DetectSentimentResult AnalyzedOneLine(String inputLine) {

// start comprehened

		String text = inputLine;

//		AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();
		Scanner sc;
		
		List<String> ArrayCreden = new ArrayList<>();  	
    	int flag = 0;
		try {
			sc = new Scanner(new File("D:\\Red\\Red\\SingelRole_credentials.csv"));
	    	sc.useDelimiter(",");  
	    	
	    	while (flag < 8)  
	    	{  
	    		String asd = sc.next().toString();
	    		if(flag ==6 || flag ==7)
	    			ArrayCreden.add(asd);
	    		flag++;
	    	}   
	    	sc.close(); 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

    	
    	
    	

    	BasicAWSCredentials awsCreds = new BasicAWSCredentials(ArrayCreden.get(0), ArrayCreden.get(1));
    	
		

		AmazonComprehend comprehendClient = AmazonComprehendClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.withRegion("ap-northeast-1").build();

		// Call detectSentiment API
//		//System.out.println("Calling DetectSentiment");
		DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest().withText(text)
				.withLanguageCode("en");
		DetectSentimentResult detectSentimentResult = comprehendClient.detectSentiment(detectSentimentRequest);
//		//System.out.println(detectSentimentResult);
//		//System.out.println("End of DetectSentiment\n");
//		//System.out.println("Done");

		////// end

		return detectSentimentResult;
	}
	
	public String AnalyzedOneLineFinal(String inputLine) {
		
		DetectSentimentResult detectSentimentResult = AnalyzedOneLine(inputLine);
		
		return detectSentimentResult.getSentiment();
	}
}
