package com.xuantujava.DTO;

public class CommentDTO extends AbstractDTO<CommentDTO>{
	private long IDCOMMENT;
	long parentIDCOMMENT;
	private long userid;
	private long courseid;
	String comment;
	
	String userName;
	String userImage;

	String userFullName;
	
	
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public long getIDCOMMENT() {
		return IDCOMMENT;
	}
	public void setIDCOMMENT(long iDCOMMENT) {
		IDCOMMENT = iDCOMMENT;
	}
	public long getParentIDCOMMENT() {
		return parentIDCOMMENT;
	}
	public void setParentIDCOMMENT(long parentIDCOMMENT) {
		this.parentIDCOMMENT = parentIDCOMMENT;
	}
	public long getUserid() {
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
}
