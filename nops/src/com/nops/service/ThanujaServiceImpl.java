package com.nops.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import com.nops.model.AdminModel;
import com.nops.model.PoliticalParty;
import com.nops.model.UserModel;
import com.nops.model.VoterModel;
import com.nops.util.DBConnection;

import jdk.internal.org.xml.sax.SAXException;



@SuppressWarnings("unused")
public class ThanujaServiceImpl implements ThanujaService{
	
	public static final Logger log = Logger.getLogger(ThanujaServiceImpl.class.getName());
	private static Connection con;
	private static Statement sta;
	private PreparedStatement prepa;
	
	
	public ArrayList<PoliticalParty> getAllPoliticalParties(){
		return actionOnPoliticalParty(null);
	}
	
	public PoliticalParty getPoliticalPartyById(String pid) {
		return actionOnPoliticalParty(pid).get(0);
	}
	
	private ArrayList<PoliticalParty> actionOnPoliticalParty(String partyId){
		ArrayList<PoliticalParty> al = new ArrayList<PoliticalParty>();
		
		try {
			con = DBConnection.getDBConnection();
			
			if(partyId != null && !partyId.isEmpty()) {
				prepa = con.prepareStatement("select * from politicalparty where politicalparty.partyId = ?");
				prepa.setString(1, partyId);
				
			}
			else {
				prepa = con.prepareStatement("select * from politicalparty");
			}
			
			ResultSet rs = prepa.executeQuery();
			
			while (rs.next()) {
				PoliticalParty p1 = new PoliticalParty();
				p1.setPartyId(rs.getString(1));
				p1.setPartyLogo(rs.getString(2));
				p1.setPartyName(rs.getString(3));
				p1.setAbbreivation(rs.getString(4));
				p1.setLeaderName(rs.getString(5));
				p1.setSecName(rs.getString(6));
				p1.setOfficialContact(rs.getString(7));
				p1.setOfficialEmail(rs.getString(8));
				p1.setAddressNo(rs.getString(9));
				p1.setAddressStreet(rs.getString(10));
				p1.setAddressCity(rs.getString(11));
				al.add(p1);
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
	
	public void addPoliticalParty(PoliticalParty p) {
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement("INSERT INTO politicalparty (PartyLogo, Party_Name, Abbreivation, LeaderName, SecName, OfficialContact, OfficialEmail, AddressNo, AddressStreet, AddressCity) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			con.setAutoCommit(false);
			
			prepa.setString(1, p.getPartyLogo());
			prepa.setString(2, p.getPartyName());
			prepa.setString(3, p.getAbbreivation());
			prepa.setString(4, p.getLeaderName());
			prepa.setString(5, p.getSecName());
			prepa.setString(6, p.getOfficialContact());
			prepa.setString(7, p.getOfficialEmail());
			prepa.setString(8, p.getAddressNo());
			prepa.setString(9, p.getAddressStreet());
			prepa.setString(10, p.getAddressCity());
			
			prepa.execute();
			con.commit();
			
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
	
	public PoliticalParty updatePoliticalParty(String pId, PoliticalParty p1) {
		
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement("update politicalparty as p "
					+" set p.PartyLogo = ?, p.Party_Name = ?, p.Abbreivation = ?, p.LeaderName = ?, p.SecName = ?, p.OfficialContact = ?, "
					+ "p.OfficialEmail = ?, p.AddressNo = ?, p.AddressStreet = ?, p.AddressCity = ?"
					+ " where p.partyID = ?");
			prepa.setString(1, p1.getPartyLogo());
			prepa.setString(2, p1.getPartyName());
			prepa.setString(3, p1.getAbbreivation());
			prepa.setString(4, p1.getLeaderName());
			prepa.setString(5, p1.getSecName());
			prepa.setString(6, p1.getOfficialContact());
			prepa.setString(7, p1.getOfficialEmail());
			prepa.setString(8, p1.getAddressNo());
			prepa.setString(9, p1.getAddressStreet());
			prepa.setString(10, p1.getAddressCity());
			prepa.setString(11, pId);
			
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
		
		return getPoliticalPartyById(pId);
	}
	
	public void removePP(String id) {
		if(id != null && !id.isEmpty()) {
			try {
				con = DBConnection.getDBConnection();
				prepa = con.prepareStatement("delete from politicalparty where politicalparty.PartyID = ?");
				prepa.setString(1, id);
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
	
	public VoterModel login(String un, String pw) {		
		try {
			con = DBConnection.getDBConnection();
			
			prepa = con.prepareStatement("select * from voter where nic = ? and password = ?");
			prepa.setString(1, un);
			prepa.setString(2, pw);
			ResultSet rs = prepa.executeQuery();
			
			while(rs.next()) {
				VoterModel us = new VoterModel();
				us.setVoterId(rs.getInt(1));
				us.setAreaCode(rs.getInt(14));
				
				return us;
			}
			
		}catch(Exception e) {
			System.out.println("Error in login");
		}
		return null;
	}
	
	public AdminModel loginAdmin(String un, String pw) {		
		try {
			con = DBConnection.getDBConnection();
			
			prepa = con.prepareStatement("select * from admin where userName = ? and password = ?");
			prepa.setString(1, un);
			prepa.setString(2, pw);
			ResultSet rs = prepa.executeQuery();
			
			while(rs.next()) {
				AdminModel a = new AdminModel();
				a.setAdminId(rs.getInt(1));
				a.setUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
				
				return a;
			}
			
		}catch(Exception e) {
			System.out.println("Error in login");
		}
		return null;
	}
}
