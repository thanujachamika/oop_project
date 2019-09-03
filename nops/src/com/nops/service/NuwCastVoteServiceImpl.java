package com.nops.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nops.model.CandidateModel;
import com.nops.model.CastVoteModel;
import com.nops.util.DBConnection;

public class NuwCastVoteServiceImpl implements NuwCastVoteService {

	public static final Logger log = Logger.getLogger(NuwCastVoteServiceImpl.class.getName());
	private static Connection con;  /*Connection*/
	private PreparedStatement ps1;  /*Prepared Statement*/
	
	public ArrayList<CastVoteModel> getPartyList() {
		ArrayList<CastVoteModel> PartyList = new ArrayList<>(); /*uses an arraylist*/
		con = DBConnection.getDBConnection();
		
		try {
			ps1 = con.prepareStatement("select PartyID,Party_Name,Abbreivation  from politicalparty  ");
			
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs1.next()) {
				CastVoteModel cv = new CastVoteModel();
				
				cv.setPartyid(rs1.getInt(1));
				cv.setPartyname(rs1.getString(2));
				cv.setPartyabb(rs1.getString(3));
		
				
				PartyList.add(cv);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if(ps1 != null) {
					ps1.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return PartyList; /*returns political party details*/
	}


	public ArrayList<CastVoteModel> getCandidateList(String pid, String cac) {
		ArrayList<CastVoteModel> CandidateList = new ArrayList<>(); /*uses an arraylist*/
		con = DBConnection.getDBConnection();
	
		try {
		ps1 = con.prepareStatement("select CandidateID,CandidatefName,CandidatelName  from candidate where CandidatePartyID"
				+ " = ? and CandidateAreaCode = ? or 0 ");
		ps1.setString(2,cac);
		ps1.setString(1, pid);
		ResultSet rs1 = ps1.executeQuery();
		
		while(rs1.next()) {
			CastVoteModel cv = new CastVoteModel();
			
			cv.setCandidateid(rs1.getInt(1));
			cv.setCandidatefname(rs1.getString(2));
			cv.setCandidatelname(rs1.getString(3));
			
			
			CandidateList.add(cv);
		}
		
		
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
		finally {
			try {
				if(ps1 != null) {
				ps1.close();
				}
				if(con != null) {
				con.close();
				}
			}catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
			}
		}
	
		return CandidateList; /*returns candidate details*/
	}
	
	public int addVote(CastVoteModel c1) {
		int status = 0;
		
		con = DBConnection.getDBConnection();
		try {
			ps1 = con.prepareStatement("INSERT INTO "
					+ "vote(VoterID,ElectionID,VotedParty,VoterAreaCode)"
					+ " values (?,?,?,?)");
			
			ps1.setLong(1, c1.getVoterid());
			ps1.setLong(2, c1.getElectionid());
			ps1.setLong(3, c1.getPartyid());
			ps1.setLong(4, c1.getVoterareacode());
		
			

			status = ps1.executeUpdate(); 

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if(ps1 != null) {
					ps1.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return status; 
		
		
	}
	
	public int addCandidateVote(CastVoteModel c1) {
		int status = 0;
		
		con = DBConnection.getDBConnection();
		try {
			ps1 = con.prepareStatement("INSERT INTO "
					+ "vote_candidate(voterID,electionId ,candidateID )"
					+ " values (?,?,?)");
			
			ps1.setLong(1, c1.getVoterid());
			ps1.setLong(2, c1.getElectionid());
			ps1.setLong(3, c1.getCandidateid());
		
		
			

			status = ps1.executeUpdate(); 

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if(ps1 != null) {
					ps1.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return status; 
		
		
	}
}	

