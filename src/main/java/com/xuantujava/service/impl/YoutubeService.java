package com.xuantujava.service.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/////////////// Youtube API scrape comment

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThread;
import com.google.api.services.youtube.model.CommentThreadListResponse;



@Service
public class YoutubeService {
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

	
	
    public static void main(String[] args) {
    	List<String> listComments = GetCommentsYoutube("Wy85Th3Myws");
    	
    	for (String item : listComments) {
				//System.out.println(item);
		}
    	
        }
    
    public static List<String> GetCommentsYoutube(String videoId) {
    	List<String> listComments = new ArrayList<>();
    	
    	
    	  YouTube youtubeService;
		try {
			youtubeService = getService();
			
			  // Define and execute the API request
	          List<String> listCriteria = Arrays.asList(new String[]{"id","snippet"});
	          
	          
	          YouTube.CommentThreads.List request = youtubeService.commentThreads()
	             .list(listCriteria);
	          CommentThreadListResponse response = request.setKey(DEVELOPER_KEY)
	          //	.setOrder("time")
	              .setVideoId(videoId)
	              .execute();
	          
	          List<CommentThread> listThreadComments = response.getItems();
	          
	          
	          for(CommentThread comment :listThreadComments) {
//	        	  //System.out.println(comment.getSnippet().getTopLevelComment().getSnippet().getTextDisplay());
	        	  listComments.add(comment.getSnippet().getTopLevelComment().getSnippet().getTextDisplay());
	          }
	            	
	            
			
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      
    	return listComments;
    }
	
}
