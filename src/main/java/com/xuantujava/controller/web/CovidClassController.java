	package com.xuantujava.controller.web;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/////////////// Youtube API scrape comment

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThread;
import com.google.api.services.youtube.model.CommentThreadListResponse;




@Controller(value ="covidclassControllerOfWeb")
public class CovidClassController {
/////////////// Youtube API scrape comment
	

	// You need to set this value for your code to compile.
    // For example: ... DEVELOPER_KEY = "YOUR ACTUAL KEY";
    private static final String DEVELOPER_KEY = "AIzaSyCHT6l7wJT9egYjkwenfzQHhmpHKE5HPUQ";

    private static final String APPLICATION_NAME = "Gym Center";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /**
     * Build and return an authorized API client service.
     *
     * @return an authorized API client service
     * @throws GeneralSecurityException, IOException
     */
    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
            .setApplicationName(APPLICATION_NAME)
            .build();
    }

	
	
    public static void main(String[] args)
            throws GeneralSecurityException, IOException, GoogleJsonResponseException {
            YouTube youtubeService = getService();
            // Define and execute the API request
            List<String> listCriteria = Arrays.asList(new String[]{"id","snippet"});
            
            
            YouTube.CommentThreads.List request = youtubeService.commentThreads()
               .list(listCriteria);
            CommentThreadListResponse response = request.setKey(DEVELOPER_KEY)
            	.setOrder("time")
                .setVideoId("5wwZCZcHiDs")
                .execute();
            
            
            List<CommentThread> listComments = response.getItems();
            
            for(CommentThread comment :listComments)
            	System.out.println(comment.getSnippet().getTopLevelComment().getSnippet().getTextDisplay());
           

        }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/////////////// Youtube API scrape comment
	@RequestMapping(value = "/covid-class", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		Long categoryId = 1L; 
		
		
	

		ModelAndView mav = new ModelAndView("web/covidClass");
		return mav;
	}
	
}
