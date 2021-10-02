package com.xuantujava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "new")
public class NewEntity extends BaseEntity{
	
	@Column(name = "title")
	private String title;
	@Column(name = "shortdecription", columnDefinition = "TEXT")
	private String shortDecription;
	@Column(name = "thumbnail")
	private String thumbnail;
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDecription() {
		return shortDecription;
	}
	public void setShortDecription(String shortDecription) {
		this.shortDecription = shortDecription;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
