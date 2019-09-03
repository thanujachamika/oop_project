package com.nops.model;

public class ResultsModel {
	
	private int voteCount;
	private String party;
	private double percentage;
	private int totalVotesCast;
	/**
	 * @return the voteCount
	 */
	public int getVoteCount() {
		return voteCount;
	}
	/**
	 * @param voteCount the voteCount to set
	 */
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	/**
	 * @return the party
	 */
	public String getParty() {
		return party;
	}
	/**
	 * @param i the party to set
	 */
	public void setParty(String i) {
		this.party = i;
	}
	/**
	 * @return the percentage
	 */
	public double getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public int getTotalVotesCast() {
		return totalVotesCast;
	}
	public void setTotalVotesCast(int totalVotesCast) {
		this.totalVotesCast = totalVotesCast;
	}
	
	
}
