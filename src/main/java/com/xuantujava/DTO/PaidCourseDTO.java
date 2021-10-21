package com.xuantujava.DTO;

public class PaidCourseDTO extends AbstractDTO<PaidCourseDTO>{
	private String name;
	private String s3Path;
	private String thumbnail; 	
	private String topic;
	private String description;
	private String shortDescription;
	private String sentiment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getS3Path() {
		return s3Path;
	}
	public void setS3Path(String s3Path) {
		this.s3Path = s3Path;
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

	
	
}
