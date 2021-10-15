package com.xuantujava.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.io.Files;
import com.xuantujava.service.impl.FreeCourseService;
//////////////
@MultipartConfig

@Controller(value = "courseControllerOfAdmin")
public class CourseController {
//	@Autowired
//	FreeCourseService freeCourseService;

    private static final String UPLOAD_DIRECTORY ="/images";  


	

	@RequestMapping(value = "/quan-tri/bai-hoc/them-moi", method = RequestMethod.POST)
	public ModelAndView addCourse(@RequestParam("file") MultipartFile  file, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException, ServletException {
		System.out.println("day la get post");


		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	  
	    System.out.println(path+ File.separator +filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
		// / end/* Receive file uploaded to the Servlet from the HTML5 form */
//	    Part filePart = request.getPart("file");
//	    String fileName = filePart.getSubmittedFileName();
//	    for (Part part : request.getParts()) {
//	      part.write("C:\\upload\\" + fileName);
//	    }
//	    response.getWriter().print("The file uploaded sucessfully.");
	  		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Part photo = request.getPart("photo");
		
//		
//		String realPath = request.getServletContext().getRealPath("/images");
//		String fileName = "xuantu.jpg";
//
//		photo.write(realPath + "/" + fileName);

//	
//		
//		 File myObj = new File("C:\\Users\\PC\\OneDrive\\Desktop\\New folder\\filessssssssssname.jpg");
//		 
//
//		 try {
//			if (myObj.createNewFile()) {
//			        System.out.println("File created: " + myObj.getName());
//			      } else {
//			        System.out.println("File already exists.");
//			      }
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		  
		    

		ModelAndView mav = new ModelAndView("admin/course/addItem");
		return mav;
	}

	@RequestMapping(value = "/quan-tri/bai-hoc/them-moi", method = RequestMethod.GET)
	public ModelAndView addCourse2() {
System.out.println("day la get method");
		ModelAndView mav = new ModelAndView("admin/course/addItem");
		return mav;
	}

}
