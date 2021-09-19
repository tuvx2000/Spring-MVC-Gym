package com.xuantujava.model;

import java.sql.Timestamp;

public class AbstractModel {
	private Long id;
	private Timestamp createDate;
	private Timestamp modifiedDate;
	private String createBy;
	private String modifieldBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifieldBy() {
		return modifieldBy;
	}
	public void setModifieldBy(String modifieldBy) {
		this.modifieldBy = modifieldBy;
	}
	

}
