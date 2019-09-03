package com.nops.model;

public class CastVoteModel {
	private int partyid;
	private String partyname;
	private String partyabb;
	private int candidateid;
	private String candidatefname;
	private String candidatelname;
	private int voterareacode;
	private int voterid;
	private int electionid;
	
	
	public int getVoterareacode() {
		return voterareacode;
	}
	public void setVoterareacode(int voterareacode) {
		this.voterareacode = voterareacode;
	}
	public int getVoterid() {
		return voterid;
	}
	public void setVoterid(int voterid) {
		this.voterid = voterid;
	}
	public int getElectionid() {
		return electionid;
	}
	public void setElectionid(int electionid) {
		this.electionid = electionid;
	}
	public int getPartyid() {
		return partyid;
	}
	public void setPartyid(int partyid) {
		this.partyid = partyid;
	}
	
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public String getPartyabb() {
		return partyabb;
	}
	public void setPartyabb(String partyabb) {
		this.partyabb = partyabb;
	}
	
	public int getCandidateid() {
		return candidateid;
	}
	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
	}
	public String getCandidatefname() {
		return candidatefname;
	}
	public void setCandidatefname(String candidatefname) {
		this.candidatefname = candidatefname;
	}
	public String getCandidatelname() {
		return candidatelname;
	}
	public void setCandidatelname(String candidatelname) {
		this.candidatelname = candidatelname;
	}
	
	
}
