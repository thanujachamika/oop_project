package com.nops.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nops.model.ElectionModel;
import com.nops.util.DBConnection;

public class HeshServiceImpl implements HeshService{
	
	public static final Logger log = Logger.getLogger(ThanujaServiceImpl.class.getName());
	private static Connection con;
	private PreparedStatement prepa;
	
	public ArrayList<ElectionModel> getAllElections(){
		return actionOnElections(null);
		}
	
	public ElectionModel getElectionById(String Eid) {
		return actionOnElections(Eid).get(0);
		}
	private ArrayList<ElectionModel> actionOnElections(String Eid){
		ArrayList<ElectionModel> al = new ArrayList<ElectionModel>();
		
		try {
			con = DBConnection.getDBConnection();
			
			if(Eid != null && !Eid.isEmpty()) {
				prepa = con.prepareStatement("select * from electiontype where electiontype.ElectionID = ?");
				prepa.setString(1, Eid);
				
			}
			else {
				prepa = con.prepareStatement("select * from electiontype");
			}
			
			ResultSet rs = prepa.executeQuery();
			
			while (rs.next()) {
				ElectionModel e1 = new ElectionModel();
				e1.setEid(Integer.parseInt(rs.getString(1)));
				e1.setEname(rs.getString(2));
				e1.setDate(rs.getString(3));
				e1.setEcycle(Integer.parseInt(rs.getString(4)));
				al.add(e1);
			}
			
			
		}catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
		finally {
			try {
				if(prepa != null) {
					prepa.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return al;
	}

	public void addElections(ElectionModel e) {
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement("INSERT INTO electiontype (ElectionID, ElectionName, ElectionDate, ElectionCycle) "
					+ "VALUES (?, ?, ?, ?)");
			con.setAutoCommit(false);
			
			prepa.setInt(1, e.getEid());
			prepa.setString(2, e.getEname());
			prepa.setString(3, e.getDate());
			prepa.setInt(4, e.getEcycle());
		
			prepa.execute();
			con.commit();
			
		}catch(SQLException e1) {
			log.log(Level.SEVERE, e1.getMessage());
		}
		
		finally {
			try {
				if(prepa != null) {
					prepa.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e2) {
				log.log(Level.SEVERE, e2.getMessage());
			}
		}
		
	}
	
	public int updateElection(String Eid, ElectionModel e1) {
		
		int status =0;
		
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement("Update electiontype set ElectionName = ?, ElectionDate = ?, ElectionCycle = ? where ElectionID = ? ");
			
			prepa.setString(1, e1.getEname());
			prepa.setString(2, e1.getDate());
			prepa.setInt(3, e1.getEcycle());
			prepa.setInt(4, Integer.parseInt(Eid));
			
			status = prepa.executeUpdate();
			
		}catch(SQLException e) {	
			log.log(Level.SEVERE, e.getMessage());	
		}
		
		finally {
			try {
				if(prepa != null) {
					prepa.close();
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

	public void removeElection(String Eid) {
		if(Eid != null && !Eid.isEmpty()) {
			try {
				con = DBConnection.getDBConnection();
				prepa = con.prepareStatement("delete from electiontype where electiontype.ElectionID = ?");
				prepa.setString(1, Eid);
				prepa.executeUpdate();
				
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			finally {
				try {
					if(prepa != null) {
						prepa.close();
					}
					if(con != null) {
						con.close();
					}
				}catch(SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		
	}
	
	}
}
