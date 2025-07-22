package com.predfut.demospringsecurity.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String uId;
	private String uPassword;
	@Override
	public String toString() {
		return "Users [id=" + id + ", uId=" + uId + ", uPassword=" + uPassword + "]";
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users(String uId, String uPassword) {
		super();
		this.uId = uId;
		this.uPassword = uPassword;
	}
	

}
