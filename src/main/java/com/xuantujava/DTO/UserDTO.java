package com.xuantujava.DTO;

import java.sql.Time;
import java.sql.Timestamp;

public class UserDTO extends AbstractDTO<UserDTO>  {
	
	private String userName;
	private String fullName;
	private String password;
	private int status;
	private Long roleId;
	private Integer statusPaid;

	
	
	public Integer getStatusPaid() {
		return statusPaid;
	}
	public void setStatusPaid(Integer statusPaid) {
		this.statusPaid = statusPaid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	
	
	

}
