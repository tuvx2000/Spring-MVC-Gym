package com.xuantujava.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.converter.NewConverter;
import com.xuantujava.entity.CategoryEntity;
import com.xuantujava.entity.NewEntity;
import com.xuantujava.repository.CategoryRepository;
import com.xuantujava.repository.NewRepository;
import com.xuantujava.service.INewService;
@Service
public class NewService implements INewService{

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;
	 
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

	@Override
	public NewDTO save(NewDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		if (dto.getId() != null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());
			oldNew.setCategory(category);
			newEntity = newConverter.toEntity(oldNew, dto);
		} else {
			newEntity = newConverter.toEntity(dto);
			newEntity.setCategory(category);
		}
		return newConverter.toDto(newRepository.save(newEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			newRepository.delete(id);
		}
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity entity = newRepository.findOne(id);
		return newConverter.toDto(entity);
	}
	
	



}

