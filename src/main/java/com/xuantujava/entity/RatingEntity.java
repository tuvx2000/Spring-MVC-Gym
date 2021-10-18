package com.xuantujava.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class RatingEntity {

	@EmbeddedId
	RatingKey id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "userid")
	UserEntity student;

	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "courseid")
	PaidCourseEntity course;
		
	Long rating;

	public RatingKey getId() {
		return id;
	}

	public void setId(RatingKey id) {
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

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}
	
	
	
	
	
	
}
