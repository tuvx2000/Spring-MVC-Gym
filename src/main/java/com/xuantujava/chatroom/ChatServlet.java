package com.xuantujava.chatroom;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/chat/{clientId}")
public class ChatServlet {
    private static Set<Session> userSessions = Collections.newSetFromMap(new ConcurrentHashMap<Session, Boolean>());
    
    @OnOpen
    public void onOpen(@PathParam("clientId") String clientId,Session curSession)
    {


//    	System.out.println("Open curSession: " + curSession);   	

    	
        userSessions.add(curSession);

        
    	int flag = 0;
        for(Session ses : userSessions)
        {
//            ses.getAsyncRemote().sendText("AmountUse: " + userSessions.size());

        	if(flag !=0 ) break;
        	System.out.println("Amount ADD: " + userSessions.size());
            ses.getAsyncRemote().sendText("AmountUse: " + userSessions.size());
            flag++;
        
        }
        
   
    	
    }
            
    @OnClose
    public void onClose(@PathParam("clientId") String clientId,Session curSession)
    {
//    	System.out.println("Close curSession: " + curSession);

        userSessions.remove(curSession);
      
    	int flag = 0;
        for(Session ses : userSessions)
        {
        	System.out.println("Amount SUBB: " + userSessions.size());
//            ses.getAsyncRemote().sendText("AmountUse: " + userSessions.size());

        	if(flag !=0 ) break;
            ses.getAsyncRemote().sendText("AmountUse: " + userSessions.size());
            flag++;
        
        }
        
       
        
    }
    
    @OnMessage
    public void onMessage(@PathParam("clientId") String clientId,String message, Session userSession)
    {
    	
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String UserName = auth.getName();
        for(Session ses : userSessions)
        {
          //  	System.out.println("on Message userSession(RAW): " + message);

            ses.getAsyncRemote().sendText(clientId + " : " + message);
        }
    }
}
