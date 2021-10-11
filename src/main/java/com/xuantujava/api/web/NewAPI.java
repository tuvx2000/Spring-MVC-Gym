package com.xuantujava.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.entity.APIEntity;
import com.xuantujava.repository.APIRepository;

@RestController(value = "newAPIOfWeb")
public class NewAPI {
	
	
	@Autowired
	APIRepository apiRepository;
	
	@PostMapping("/api/new")
	public String createNew(@RequestBody APIEntity apiEntity) {
		
		apiRepository.save(apiEntity);
		return "Thanh Cong them moi";
	}
	@GetMapping("/api/new")
	public FormReturnAPI getNew() {
		FormReturnAPI xxx =  new FormReturnAPI();
		
		
		
		
		return xxx; 
	}
	
	
	

		public class FormReturnAPI{
			private String title = " hello ";
			private String Owner = " xuantu";
			private List<APIEntity> Data = apiRepository.findAll();

	
			public List<APIEntity> getData() {
				return Data;
			}
			public void setData(List<APIEntity> data) {
				Data = data;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getOwner() {
				return Owner;
			}
			public void setOwner(String owner) {
				Owner = owner;
			}
			
			
			
		}
	
}



