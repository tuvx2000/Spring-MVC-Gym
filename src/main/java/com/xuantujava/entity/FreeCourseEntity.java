package com.xuantujava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "freecourse")
public class FreeCourseEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "linkyoutube")
	private String linkyoutube;

	@Column(name = "thumbnail")
	private String thumbnail;

	@Column(name = "topic")
	private String topic;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkyoutube() {
		return linkyoutube;
	}

	public void setLinkyoutube(String linkyoutube) {
		this.linkyoutube = linkyoutube;
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
