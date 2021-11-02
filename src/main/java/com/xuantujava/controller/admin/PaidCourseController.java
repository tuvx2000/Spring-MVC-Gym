package com.xuantujava.controller.admin;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.io.Files;
import com.xuantujava.DTO.CommentDTO;
import com.xuantujava.DTO.FreeCourseDTO;
import com.xuantujava.DTO.PaidCourseDTO;
import com.xuantujava.repository.PaidCourseRepository;
import com.xuantujava.service.IPaidCourseService;
import com.xuantujava.service.impl.FreeCourseService;
//////////////
import com.xuantujava.service.impl.PaidCourseService;
import com.xuantujava.util.MessageUtil;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.AmazonServiceException;

@MultipartConfig
@Controller(value = "courseControllerOfAdmin")
public class PaidCourseController {

	@Autowired
	IPaidCourseService paidCourseService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	
	//list
	@RequestMapping(value = "/quan-tri/bai-hoc-tra-phi/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		PaidCourseDTO model = new PaidCourseDTO();
		Pageable pageable = new PageRequest(page -1, limit);
		ModelAndView mav = new ModelAndView("admin/paidCourse/list");

		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messageResponse", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		
		model.setPage(page);
		model.setLimit(limit);
		
		
		model.setTotalItem(paidCourseService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		model.setListResult(paidCourseService.findAll(pageable));
		
		
		
		mav.addObject("model", model);
		return mav;
	}
	
	
	//add
	
	@RequestMapping(value = "/quan-tri/bai-hoc-tra-phi/chinh-sua", method = RequestMethod.GET)
	public ModelAndView addCourseget( HttpServletRequest request,
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/paidCourse/addPaidCourse");

		
		PaidCourseDTO model = new PaidCourseDTO();
		if (id != null) {
			model = paidCourseService.findById(id);
			System.out.println("comment id: "+ id + " / " + model.getS3Path());
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messageResponse", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		System.out.println("here is the get method");
		mav.addObject("model", model);
		return mav;
	}


	@RequestMapping(value = "/quan-tri/bai-hoc-tra-phi/chinh-sua", method = RequestMethod.POST)
	public ModelAndView addCourse(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			@RequestParam(value = "id", required = false) Long id,
			HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		System.out.println("step1");
		ModelAndView mav = new ModelAndView("admin/paidCourse/addPaidCourse");

		if(id != null) {
			System.out.println("step2");
			
		//day la them moi

		String filename = file.getOriginalFilename();
		File xx = multipartToFile(file,filename);

		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("ap-southeast-1").build();
		List<Bucket> buckets = s3.listBuckets();

		ListObjectsV2Result result = s3.listObjectsV2("xuantu-spring-db");
		List<S3ObjectSummary> objects = result.getObjectSummaries();
		for (S3ObjectSummary os : objects) {
		    //System.out.println("* " + os.getKey());
		}


		try {
		    s3.putObject("xuantu-spring-db", filename, xx);
		} catch (AmazonServiceException e) {
		    System.err.println(e.getErrorMessage());
		    System.exit(1);
		}

		
		PaidCourseDTO paidCourseDTO = new PaidCourseDTO();
		paidCourseDTO.setS3Path("https://xuantu-spring-db.s3.ap-southeast-1.amazonaws.com/" +filename);
		paidCourseDTO.setName(request.getParameter("name"));
		paidCourseDTO.setDescription(request.getParameter("description"));
		paidCourseDTO.setShortDescription(request.getParameter("shortdescription"));
		paidCourseDTO.setTopic(request.getParameter("topic"));
		paidCourseDTO.setThumbnail(request.getParameter("thumbnail"));
		
		
		paidCourseService.addPaidCourse(paidCourseDTO);

		}
		//day la het them moi

		System.out.println("step3");

		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messageResponse", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		

		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public  static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
	    File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
	    multipart.transferTo(convFile);
	    return convFile;
	}
	

	@RequestMapping(value = "/quan-tri/bai-hoc/them-moi", method = RequestMethod.GET)
	public ModelAndView addCourse2() {
		//System.out.println("day la get method");
		ModelAndView mav = new ModelAndView("admin/course/addPaidCourse");
		return mav;
	}

}
