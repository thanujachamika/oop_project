package com.nops.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.nops.model.CastVoteModel;
import com.nops.util.DBConnection;

@SuppressWarnings("unused")
public interface NuwCastVoteService {
	public ArrayList<CastVoteModel> getPartyList();
	public ArrayList<CastVoteModel> getCandidateList(String pid, String cac);
	public int addVote(CastVoteModel c1);
	public int addCandidateVote(CastVoteModel c1);
}		