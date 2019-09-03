package com.nops.model;

public class ElectionModel {
	
	private int Eid;
	private String Ename;
	private String Date;
	private int Ecycle;
	
	
	public ElectionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ElectionModel(int eid, String ename, String date, int ecycle) {
		super();
		Eid = eid;
		Ename = ename;
		Date = date;
		Ecycle = ecycle;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getEcycle() {
		return Ecycle;
	}
	public void setEcycle(int ecycle) {
		Ecycle = ecycle;
	}
	
	

}
