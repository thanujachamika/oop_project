package com.nops.service;

import java.util.ArrayList;

import com.nops.model.AdminModel;
import com.nops.model.PoliticalParty;
import com.nops.model.UserModel;
import com.nops.model.VoterModel;

public interface ThanujaService {
	public ArrayList<PoliticalParty> getAllPoliticalParties();
	public PoliticalParty getPoliticalPartyById(String pid);
	public void addPoliticalParty(PoliticalParty p);
	public PoliticalParty updatePoliticalParty(String pId, PoliticalParty p1);
	public void removePP(String id);
	public VoterModel login(String un, String pw);
	public AdminModel loginAdmin(String un, String pw);
}
