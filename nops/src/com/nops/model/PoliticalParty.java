package com.nops.model;

public class PoliticalParty {
	private String partyId;
	private String partyLogo;
	private String partyName;
	private String abbreivation;
	private String leaderName;
	private String secName;
	private String officialContact;
	private String officialEmail;
	private String addressNo;
	private String addressStreet;
	private String addressCity;
	
	public PoliticalParty() {
		
	}
	
	public PoliticalParty(String partyId, String partyLogo, String partyName, String abbreivation, String leaderName,
			String secName, String officialContact, String officialEmail, String addressNo, String addressStreet,
			String addressCity) {
		super();
		this.partyId = partyId;
		this.partyLogo = partyLogo;
		this.partyName = partyName;
		this.abbreivation = abbreivation;
		this.leaderName = leaderName;
		this.secName = secName;
		this.officialContact = officialContact;
		this.officialEmail = officialEmail;
		this.addressNo = addressNo;
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getPartyLogo() {
		return partyLogo;
	}

	public void setPartyLogo(String partyLogo) {
		this.partyLogo = partyLogo;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getAbbreivation() {
		return abbreivation;
	}

	public void setAbbreivation(String abbreivation) {
		this.abbreivation = abbreivation;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String getOfficialContact() {
		return officialContact;
	}

	public void setOfficialContact(String officialContact) {
		this.officialContact = officialContact;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
}
