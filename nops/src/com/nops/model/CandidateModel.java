package com.nops.model;

public class CandidateModel {
	
	public String fname;	/*Variable Declaration*/
	private String lname;
	private String nic;
	private String dob;
	private int candidatePartyID;
	private int electionID;
	private int areaCode;
	private String gender;
	private String race;
	private String addNo;
	private String addStreet;
	private String addCity;
	private int contactNo;
	private String email;
	
	

	/*Overloaded Constructor*/
	public CandidateModel(String fname, String lname, String nic, String dob, int candidatePartyID, int electionID,
		String gender, String addNo, String addStreet, String addCity, String race, String email, int contactNo,
		int areaCode) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.nic = nic;
	this.dob = dob;
	this.candidatePartyID = candidatePartyID;
	this.electionID = electionID;
	this.gender = gender;
	this.addNo = addNo;
	this.addStreet = addStreet;
	this.addCity = addCity;
	this.race = race;
	this.email = email;
	this.contactNo = contactNo;
	this.areaCode = areaCode;
	}
	
	/*Default Constructor*/
	public CandidateModel() {
	}

	/*Relevant Getters and Setters*/
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getCandidatePartyID() {
		return candidatePartyID;
	}

	public void setCandidatePartyID(int candidatePartyID) {
		this.candidatePartyID = candidatePartyID;
	}

	public int getElectionID() {
		return electionID;
	}

	public void setElectionID(int electionID) {
		this.electionID = electionID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddNo() {
		return addNo;
	}

	public void setAddNo(String addNo) {
		this.addNo = addNo;
	}

	public String getAddStreet() {
		return addStreet;
	}

	public void setAddStreet(String addStreet) {
		this.addStreet = addStreet;
	}

	public String getAddCity() {
		return addCity;
	}

	public void setAddCity(String addCity) {
		this.addCity = addCity;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	
	
}	