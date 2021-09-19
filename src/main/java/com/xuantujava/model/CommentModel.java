package com.xuantujava.model;

import java.sql.Time;
import java.sql.Timestamp;

public class CommentModel extends AbstractModel {
	
	private String content;
	private Long userId;
	private Long newId;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getNewId() {
		return newId;
	}
	public void setNewId(Long newId) {
		this.newId = newId;
	}
	
	


	

}
