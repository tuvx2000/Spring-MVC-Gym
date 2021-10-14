package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.entity.NewEntity;
import com.xuantujava.repository.NewRepository;
import com.xuantujava.service.INewService;
@Service
public class NewService implements INewService{

	@Autowired
	private NewRepository newRepository;
	 
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> listModel = new ArrayList<>();
		List<NewEntity> listEntitie = newRepository.findAll(pageable).getContent();
		for( NewEntity item: listEntitie) {
			NewDTO hold = new NewDTO();
			hold.setTitle(item.getTitle());
			listModel.add(hold);
		}
		return listModel;
	}

	@Override
	public int getTotalItem() {
		
		return (int) newRepository.count();
	}
	
	



}

