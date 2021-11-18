package com.xuantujava.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

////comprehened imports
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;

///end ////comprehened imports
public class AwsComprehenedService {
	
    public static void main(String[] args) throws FileNotFoundException {
    //	String sentimentComment = AnalyzedOneLineFinal("Wy85Th3Myws").toString();
//    	BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAUVLNBEMDG2PFDEP2", "vWyWMm6LvfVwgTZOW8EBYc4JyWOpeBSDBrF2fu+w");

//    	com.amazonaws.auth.DefaultAWSCredentialsProviderChain@221af3c0

    	//parsing a CSV file into Scanner class constructor  
    	Scanner sc = new Scanner(new File("D:\\Red\\Red\\SingelRole_credentials.csv"));  
    	sc.useDelimiter(",");   //sets the delimiter pattern 
    	
    	int flag = 0;
    	while (sc.hasNext())  //returns a boolean value  
    	{  
    		int x = flag;
    		System.out.println("Flag:" +flag);
//    		if( x == 7 )//|| flag == 7)
    			System.out.println(sc.next());
//    		if(flag >2000) break;
    		flag++;
    	}   
    	sc.close();  //closes the scanner  
    	  
//    	System.out.println(awsCreds);
    	
        }



	public static DetectSentimentResult AnalyzedOneLine(String inputLine) {

		// start comprehened

		String text = inputLine;

		AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();

		AmazonComprehend comprehendClient = AmazonComprehendClientBuilder.standard().withCredentials(awsCreds)
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
	
	public static String AnalyzedOneLineFinal(String inputLine) {
		
		DetectSentimentResult detectSentimentResult = AnalyzedOneLine(inputLine);
		
		return detectSentimentResult.getSentiment();
	}
}
