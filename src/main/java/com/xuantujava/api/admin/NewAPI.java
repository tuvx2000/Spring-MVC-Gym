package com.xuantujava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.service.INewService;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	@Autowired
	private INewService newService;
	
//	
//	@PostMapping("/api/new")
//	public NewDTO createNew(@RequestBody NewDTO newDTO) {
//		return newDTO;
//	}
//	@GetMapping("/api/new")
//	public String getNew(@RequestBody NewDTO newDTO) {
//		return "um ba la xi bua"; 
//	}
	
	
	
	
	@PostMapping("/api/new")
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		newService.save(newDTO);
		
		return newDTO;
	}
	
	@PutMapping("/api/new")
	public NewDTO updateNew(@RequestBody NewDTO updateNew) {
		newService.save(updateNew);

		return updateNew;
	}
	
	@DeleteMapping("/api/new")
	public void deleteNew(@RequestBody long[] ids) {	
		newService.delete(ids);
	}
}
