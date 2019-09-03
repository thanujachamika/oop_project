package com.nops.service;
import java.util.ArrayList;

import com.nops.model.CandidateModel;

public interface NuwCandidateService {

	   /*These Methods are implemented in NuwCandidateServiceImpl.java*/
	public int registerCandidate(CandidateModel c1);
	public int updateCandidate(CandidateModel c1, String nic );
	public void deleteCandidate(String candidateNIC);
	public ArrayList<CandidateModel> getCandidateList();
	public CandidateModel getCandidateDetails(String nic);
	
}
