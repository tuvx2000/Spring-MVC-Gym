package com.xuantujava.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value ="apiControllerOfWeb")

public class api {

	
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String apiGetPage() {
		return 
				"{\r\n" + 
				"    \"about\": \"This is a Tu's API.\",\r\n" + 
				"    \"data\": [\r\n" + 
				"        {\r\n" + 
				"            \"Id\": \"12312312\",\r\n" + 
				"            \"Name\": \"Tu\",\r\n" + 
				"            \"Url\": \"John\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"Id\": \"1143232413412\",\r\n" + 
				"            \"Name\": \"Tuong\",\r\n" + 
				"            \"Url\": \"John\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"Id\": \"132413241324\",\r\n" + 
				"            \"Name\": \"Linh\",\r\n" + 
				"            \"Url\": \"John\"\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
	}
}
