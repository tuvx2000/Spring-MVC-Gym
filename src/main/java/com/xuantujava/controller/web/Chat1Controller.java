package com.xuantujava.controller.web;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.xuantujava.entity.Greeting;
import com.xuantujava.entity.HelloMessage;

import org.springframework.stereotype.Controller;

@Controller(value ="chat1ControllerControllerOfWeb")
public class Chat1Controller {

	@MessageMapping("/say")
	@SendTo("/topic/chat")
	public Greeting say(HelloMessage helloMessage) throws Exception {
		return new Greeting(HtmlUtils.htmlEscape(helloMessage.getName()));
	}

}