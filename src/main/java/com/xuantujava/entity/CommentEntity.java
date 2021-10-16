package com.xuantujava.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CommentEntity {

	@EmbeddedId
	CommentKey id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "userid")
	UserEntity student;

	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "courseid")
	PaidCourseEntity course;
	
	
	int levelComment;
	
	String comment;

	public CommentKey getId() {
		return id;
	}

	public void setId(CommentKey id) {
		this.id = id;
	}

	public UserEntity getStudent() {
		return student;
	}

	public void setStudent(UserEntity student) {
		this.student = student;
	}

	public PaidCourseEntity getCourse() {
		return course;
	}

	public void setCourse(PaidCourseEntity course) {
		this.course = course;
	}

	public int getLevelComment() {
		return levelComment;
	}

	public void setLevelComment(int levelComment) {
		this.levelComment = levelComment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
}
