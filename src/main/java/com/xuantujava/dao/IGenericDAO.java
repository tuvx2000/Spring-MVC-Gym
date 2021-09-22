package com.xuantujava.dao;

import java.util.List;

import javax.swing.tree.RowMapper;

import com.xuantujava.mapper.IRowMapper;

public interface IGenericDAO<T> {
	<T> List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
}
