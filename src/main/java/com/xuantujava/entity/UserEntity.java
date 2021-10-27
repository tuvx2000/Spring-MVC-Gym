package com.xuantujava.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullName;

	@Column
	private Integer status;

	@Column
	private Integer statusPaid;

	@Column
	private String dayExpired;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<RoleEntity> roles = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "comment", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "courseid"))
	private List<PaidCourseEntity> paidCourse = new ArrayList<>();

	@OneToMany(targetEntity=TransactionEntity.class)  
    private List transaction;  


	public void setTransaction(List transaction) {
		this.transaction = transaction;
	}

	public Integer getStatusPaid() {
		return statusPaid;
	}

	public void setStatusPaid(Integer statusPaid) {
		this.statusPaid = statusPaid;
	}

	public String getDayExpired() {
		return dayExpired;
	}

	public void setDayExpired(String dayExpired) {
		this.dayExpired = dayExpired;
	}

	public List<TransactionEntity> getTransaction() {
		return transaction;
	}



	public List<PaidCourseEntity> getPaidCourse() {
		return paidCourse;
	}

	public void setPaidCourse(List<PaidCourseEntity> paidCourse) {
		this.paidCourse = paidCourse;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
}