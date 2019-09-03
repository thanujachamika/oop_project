package com.nops.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nops.model.ElectionModel;
import com.nops.model.ResultsModel;
import com.nops.util.DBConnection;

public class ImalResultsService {
	
	public ArrayList<ElectionModel> returnElectionList(String electionName){
		
		ArrayList<ElectionModel> electionList = new ArrayList<ElectionModel>();
		
		Connection con = DBConnection.getDBConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM 	electiontype WHERE ElectionName = '"+electionName+"'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ElectionModel e1 = new ElectionModel();
				
				e1.setEid(rs.getInt(1));
				e1.setEname(rs.getString(2));
				e1.setDate(rs.getString(3));
				e1.setEcycle(rs.getInt(4));
				
				electionList.add(e1);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return electionList;
		
		
	}
	
	public ArrayList<ResultsModel> countVotesByParty(String electionID) {
		
		 Connection con = DBConnection.getDBConnection();
		 ArrayList<ResultsModel> resultList = new ArrayList<ResultsModel>();
		 
		
		
		try {

			
			PreparedStatement ps = con.prepareStatement("Select count(*) as totVotes,p.Party_Name\r\n" + 
					"from vote v, politicalparty p\r\n" + 
					"where  v.VotedParty = p.PartyID and  electionID = ? \r\n" + 
					"group by v.VotedParty, p.Party_Name");
			ps.setString(1, electionID);
			ResultSet rs = ps.executeQuery();
			
			//PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*)  FROM vote");
			//ResultSet rs2 = ps2.executeQuery();
			
			
			while(rs.next()) {
				
				ResultsModel r1 = new ResultsModel();
				
				r1.setVoteCount(rs.getInt(1));
				r1.setParty(rs.getString(2));
				
				
				
				resultList.add(r1);
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
		
		
		
		
		
	}
	

}
