package com.nops.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nops.model.CandidateModel;

import com.nops.util.DBConnection;

public class NuwCandidateServiceImpl implements NuwCandidateService {
	public static final Logger log = Logger.getLogger(NuwCandidateServiceImpl.class.getName());
	private static Connection con;  /*Connection*/
	private PreparedStatement ps1;  /*Prepared Statement*/
	
	
	@Override
	/*To register candidate*/
	public int registerCandidate(CandidateModel c1) {
		int status = 0;
		
		con = DBConnection.getDBConnection();
		try {
			ps1 = con.prepareStatement("INSERT INTO "
					+ "candidate(Candidatefname,Candidatelname,CandidateNIC,DateofBirth,CandidatePartyID,ElectionID,CandidateAreaCode,Gender,Race,AddressNo,"
					+ "AddressStreet,AddressCity,ContactNo,Email)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps1.setString(1, c1.getFname());
			ps1.setString(2, c1.getLname());
			ps1.setString(3, c1.getNic());
			ps1.setString(4, c1.getDob());
			ps1.setLong(5, c1.getCandidatePartyID());
			ps1.setLong(6, c1.getElectionID());
			ps1.setLong(7, c1.getAreaCode());
			ps1.setString(8, c1.getGender());
			ps1.setString(9,c1.getRace());
			ps1.setString(10, c1.getAddNo());
			ps1.setString(11, c1.getAddStreet());
			ps1.setString(12,c1.getAddCity());
			ps1.setLong(13, c1.getContactNo());
			ps1.setString(14,c1.getEmail());
			
			

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

	@Override
	/*To update Candidate*/
	public int updateCandidate(CandidateModel c1, String nic ) {
		int status = 0;
		try {
			con = DBConnection.getDBConnection();
			ps1 = con.prepareStatement("update Candidate as c "
					+" set c.CandidatefName = ?, c.CandidatelName = ?, c.CandidateNIC = ?, c.DateofBirth = ?, c.CandidatePartyID = ?, c.ElectionID = ?, "
					+ "c.CandidateAreaCode = ?, c.Gender = ?, c.Race = ?, c.AddressNo = ?, c.AddressStreet = ?, c.AddressCity = ?, c.ContactNo = ?, c.Email = ?"
					+ " where c.CandidateNIC = ?");
			ps1.setString(1, c1.getFname());
			ps1.setString(2, c1.getLname());
			ps1.setString(3, c1.getNic());
			ps1.setString(4, c1.getDob());
			ps1.setInt(5, c1.getCandidatePartyID());
			ps1.setInt(6, c1.getElectionID());
			ps1.setInt(7, c1.getAreaCode());
			ps1.setString(8, c1.getGender());
			ps1.setString(9, c1.getRace());
			ps1.setString(10, c1.getAddNo());
			ps1.setString(11, c1.getAddStreet());
			ps1.setString(12, c1.getAddCity());
			ps1.setInt(13, c1.getContactNo());
			ps1.setString(14, c1.getEmail());
			ps1.setString(15, nic);
			
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

	@Override
	/*To delete Candidate*/
	public void deleteCandidate(String candidateNIC) {
		con = DBConnection.getDBConnection();
		
		try {
			ps1 = con.prepareStatement("DELETE FROM candidate WHERE CandidateNIC = ?");
			ps1.setString(1, candidateNIC); /*Delete using the NIC*/
			ps1.execute();
			
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
		
	}

	@Override
	/*to get the details of candidate from database to program */
	public ArrayList<CandidateModel> getCandidateList() {
		ArrayList<CandidateModel> CandidateList = new ArrayList<>(); /*uses an arraylist*/
		con = DBConnection.getDBConnection();
		
		try {
			ps1 = con.prepareStatement("select * from candidate");
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs1.next()) {
				CandidateModel c = new CandidateModel();
				
				c.setFname(rs1.getString(2));
				c.setLname(rs1.getString(3));
				c.setNic(rs1.getString(4));
				c.setDob(rs1.getString(5));
				c.setCandidatePartyID(rs1.getInt(6));
				c.setElectionID(rs1.getInt(7));
				c.setAreaCode(rs1.getInt(8));
				c.setGender(rs1.getString(9));
				c.setRace(rs1.getString(10));
				c.setAddNo(rs1.getString(11));
				c.setAddStreet(rs1.getString(12));
				c.setAddCity(rs1.getString(13));
				c.setContactNo(rs1.getInt(14));
				c.setEmail(rs1.getString(15));
				
				
				CandidateList.add(c);
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
	
	public  CandidateModel getCandidateDetails(String nic) {
		
		con = DBConnection.getDBConnection();
			
		CandidateModel c = new CandidateModel();
		try {
			 ps1 = con.prepareStatement("select * from candidate where CandidateNIC = ?");
			
			ps1.setString(1, nic);
			
			ResultSet rs1  = ps1.executeQuery();
			
			
			if(rs1.next()) {
								
				c.setFname(rs1.getString(2));
				c.setLname(rs1.getString(3));
				c.setNic(rs1.getString(4));
				c.setDob(rs1.getString(5));
				c.setCandidatePartyID(rs1.getInt(6));
				c.setElectionID(rs1.getInt(7));
				c.setAreaCode(rs1.getInt(8));
				c.setGender(rs1.getString(9));
				c.setRace(rs1.getString(10));
				c.setAddNo(rs1.getString(11));
				c.setAddStreet(rs1.getString(12));
				c.setAddCity(rs1.getString(13));
				c.setContactNo(rs1.getInt(14));
				c.setEmail(rs1.getString(15));
				
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
		
		return c;
	}
	

}
