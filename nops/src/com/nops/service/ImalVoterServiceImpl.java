package com.nops.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nops.model.VoterModel;
import com.nops.util.DBConnection;



public class ImalVoterServiceImpl implements ImalVoterService{
	
	private static Connection con;
	@SuppressWarnings("unused")
	private static Statement stmt;
	private PreparedStatement ps;

	@Override
	public int addVoter(VoterModel v1) {
		
		int status = 0;
		
		con = DBConnection.getDBConnection();
		try {
			ps = con.prepareStatement("INSERT INTO "
					+ "Voter(Mname,Lname,OtherNames,Gender,Race,DateOfBirth,NIC,AddressNo,AddressStreet,AddressCity,VoterEmail,VoterContact,VoterAreaCode)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, v1.getFname());
			ps.setString(2, v1.getLname());
			ps.setString(3, v1.getOname());
			ps.setString(4, v1.getGender());
			ps.setString(5, v1.getRace());
			ps.setString(6, v1.getDob());
			ps.setString(7, v1.getNic());
			ps.setString(8, v1.getAddNo());
			ps.setString(9, v1.getAddStreet());
			ps.setString(10, v1.getAddCity());
			ps.setString(11, v1.getEmail());
			ps.setLong(12, v1.getContactNo());
			ps.setLong(13, v1.getAreaCode());

			status = ps.executeUpdate();

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}

	@Override
	public int updateVoter(VoterModel v1) {
		
		int status = 0;

		con = DBConnection.getDBConnection();

		try {
			ps = con.prepareStatement("UPDATE Voter SET Mname = '"+v1.getFname()+"'"
					+ ",Lname = '"+v1.getLname()+"',OtherNames = '"+v1.getOname()+"',Gender = '"+v1.getGender()+"',Race = '"+v1.getGender()+"',DateOfBirth = '"+v1.getDob()+"',"
					+ "NIC = '"+v1.getNic()+"',AddressNo = '"+v1.getAddNo()+"',AddressStreet = '"+v1.getAddStreet()+"',AddressCity = '"+v1.getAddCity()+"',"
							+ "VoterEmail = '"+v1.getEmail()+"',VoterContact = '"+v1.getContactNo()+"',VoterAreaCode = '"+v1.getAreaCode()+"'"
					+ "WHERE NIC = '" + v1.getNic() + "'");
			status = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}
	

	@Override
	public void deleteVoter(String voterId) {
		
		con = DBConnection.getDBConnection();
		
		try {
			ps = con.prepareStatement("DELETE FROM Voter WHERE NIC = ?");
			ps.setString(1, voterId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ArrayList<VoterModel> getVotersList() {
		
		ArrayList<VoterModel> voterList = new ArrayList<>();
		con = DBConnection.getDBConnection();
		
		try {
			ps = con.prepareStatement("select * from voter");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				VoterModel voter = new VoterModel();
				
				voter.setFname(rs.getString(2));
				voter.setLname(rs.getString(3));
				voter.setOname(rs.getString(4));
				voter.setGender(rs.getString(5));
				voter.setRace(rs.getString(6));
				voter.setDob(rs.getString(7));
				voter.setNic(rs.getString(8));
				voter.setAddNo(rs.getString(9));
				voter.setAddStreet(rs.getString(10));
				voter.setAddCity(rs.getString(11));
				voter.setEmail(rs.getString(12));
				voter.setContactNo(rs.getInt(13));
				voter.setAreaCode(rs.getInt(14));
			
				voterList.add(voter);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return voterList;
	}

	@Override
	public int readVoterID(String nic) {
		
		int status = 0;
		
		con = DBConnection.getDBConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from voter where NIC = ?");
			
			ps.setString(1, nic);
			
			ResultSet rs  = ps.executeQuery();
			
			
			if(rs.next()) {
				
				status = 1;
				
			}
			
			
		} catch (SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return status;
	}
	
	public  VoterModel returnVoterData(String nic) {
		
		con = DBConnection.getDBConnection();
		VoterModel voter = new VoterModel();	
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from voter where NIC = ?");
			
			ps.setString(1, nic);
			
			ResultSet rs  = ps.executeQuery();
			
			
			if(rs.next()) {
								
				voter.setFname(rs.getString(2));
				voter.setLname(rs.getString(3));
				voter.setOname(rs.getString(4));
				voter.setGender(rs.getString(5));
				voter.setRace(rs.getString(6));
				voter.setDob(rs.getString(7));
				voter.setNic(rs.getString(8));
				voter.setAddNo(rs.getString(9));
				voter.setAddStreet(rs.getString(10));
				voter.setAddCity(rs.getString(11));
				voter.setEmail(rs.getString(12));
				voter.setContactNo(rs.getInt(13));
				voter.setAreaCode(rs.getInt(14));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return voter;
	}
	
	

}
