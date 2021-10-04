package com.xuantujava.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuantujava.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
