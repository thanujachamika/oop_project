package com.nops.service;

import java.util.ArrayList;

import com.nops.model.VoterModel;

public interface ImalVoterService {
	
	public  int readVoterID(String nic);
	public int addVoter(VoterModel v1);
	public int updateVoter(VoterModel v1);
	public void deleteVoter(String voterId);
	public ArrayList<VoterModel> getVotersList();
}
