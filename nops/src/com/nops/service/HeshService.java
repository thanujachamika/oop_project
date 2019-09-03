package com.nops.service;

import java.util.ArrayList;

import com.nops.model.ElectionModel;

public interface HeshService {
	
	public ArrayList<ElectionModel> getAllElections();
	public ElectionModel getElectionById(String Eid);
	public void addElections(ElectionModel e);
	public int updateElection(String eid, ElectionModel e1);
	public void removeElection(String Eid);
}
