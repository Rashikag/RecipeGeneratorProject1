package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_detail")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_password")
	private String userPassword;
	@Column(name="user_gmail")
	private String userGmail;
	
	
	public User() {
	}
	
	public User(int userId, String userName, String userPassword, String userGmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userGmail = userGmail;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserGmail() {
		return userGmail;
	}
	public void setUserGmail(String userGmail) {
		this.userGmail = userGmail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userGmail="
				+ userGmail + "]";
	}

	
}
