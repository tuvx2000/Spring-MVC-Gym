package com.xuantujava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity{
	
	@Column(name = "parentid")
	private long parentId;

	@Column(name = "comment")
	private String comment;

	@Column(name = "userid")
	private long userid;

	@Column(name = "courseid")
	private long courseid;

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getUserid() {
		return userid;
	}


	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getCourseid() {
		return courseid;
	}

	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}
	
	
}
