package com.manish.dinesh.projecthomeatomation.Models;

import java.util.Date;

public class User {

	private int uid;
	
	private String name;
	private Date dob;
	private String emailId;
	private String pwd; 
	private int aid;
	
	public User(int uid, String name, Date dob, String emailId, String pwd, int aid) {
		super();
		this.uid = uid;
		this.name = name;
		this.dob = dob;
		this.emailId = emailId;
		this.pwd = pwd;
		this.aid = aid;
	}

	public User() {
		super();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getemailId() {
		return emailId;
	}

	public void setemailId(String emailId) {
		this.emailId = emailId;
	}

	public String getpwd() {
		return pwd;
	}

	public void setpwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", dob=" + dob + ", emailId=" + emailId + ", pwd=" + pwd
				+ ", aid=" + aid + "]";
	}
	
}
