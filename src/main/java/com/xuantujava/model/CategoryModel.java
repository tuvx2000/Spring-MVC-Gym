package com.xuantujava.model;

import java.sql.Time;
import java.sql.Timestamp;

public class CategoryModel extends AbstractModel {
	
	private String name;
	private String code;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	

}
