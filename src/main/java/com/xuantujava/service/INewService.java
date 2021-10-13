package com.xuantujava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.xuantujava.DTO.NewDTO;

public interface INewService {
	int getTotalItem();
	List<NewDTO> findAll(Pageable pageable);
}
