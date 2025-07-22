package com.predfut.demospringsecurity.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentDetails {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int sId;
	private String sName;
	private String sCourseName;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsCourseName() {
		return sCourseName;
	}
	public void setsCourseName(String sCourseName) {
		this.sCourseName = sCourseName;
	}
	@Override
	public String toString() {
		return "StudentDetails [sId=" + sId + ", sName=" + sName + ", sCourseName=" + sCourseName + "]";
	}
	public StudentDetails(int sId, String sName, String sCourseName) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sCourseName = sCourseName;
	}
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
