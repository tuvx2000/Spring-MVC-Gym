package com.xuantujava.api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuantujava.DTO.NewDTO;

@RestController(value = "newAPIOfWeb")
public class NewAPI {
	@PostMapping("/api/new")
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		return newDTO;
	}
	@GetMapping("/api/new")
	public String getNew() {
		return "um ba la xi bua"; 
	}
}
