package com.xuantujava.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paidcourse")
public class PaidCourseEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "s3path")
	private String s3Path;

	@Column(name = "thumbnail")
	private String thumbnail; 	

	@Column(name = "topic")
	private String topic;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "shotdescription", columnDefinition = "TEXT")
	private String shortDescription;
	
	@Column(name = "sentiment", columnDefinition = "TEXT")
	private String sentiment;

	 @ManyToMany(mappedBy = "paidCourse")
	    private List<UserEntity> users = new ArrayList<>();
	 
	 
	 
	
	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public String getS3Path() {
		return s3Path;
	}

	public void setS3Path(String s3Path) {
		this.s3Path = s3Path;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
