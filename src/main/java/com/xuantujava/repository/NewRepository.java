package com.xuantujava.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.DTO.NewDTO;
import com.xuantujava.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {

}