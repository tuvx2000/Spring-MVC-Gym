package com.xuantujava.DTO;

public class FreeCourseDTO extends AbstractDTO<FreeCourseDTO> {

	private String name;
	private String linkyoutube;
	private String thumbnail;
	private String topic;
	private String description;
	
	private String sentiment;

	
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
