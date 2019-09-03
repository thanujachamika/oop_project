package com.nops.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nops.model.VoterModel;
import com.nops.service.ImalVoterServiceImpl;

/**
 * Servlet implementation class ImalUpdateVoterServlet
 */
@WebServlet("/ImalUpdateVoterServlet")
public class ImalUpdateVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImalUpdateVoterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ImalVoterServiceImpl db = new ImalVoterServiceImpl();
		VoterModel voter = db.returnVoterData(request.getParameter("nic"));
		
		String fname = voter.getFname();
		String lname = voter.getLname();
		String oname = voter.getOname();
		String nic = voter.getNic();
		String dob = voter.getDob();
		String addNo = voter.getAddNo();
		String addStreet = voter.getAddStreet();
		String addCity = voter.getAddCity();
		String gender = voter.getGender();
		String race = voter.getRace();
		String email = voter.getEmail();
		int contactNo = voter.getContactNo();
		int areaCode = voter.getAreaCode();
		
		request.setAttribute("Fname", fname);
		request.setAttribute("Lname", lname);
		request.setAttribute("Oname", oname);
		request.setAttribute("NIC", nic);
		request.setAttribute("DOB", dob);
		request.setAttribute("AddLine1", addNo);
		request.setAttribute("AddLine2", addStreet);
		request.setAttribute("AddLine3", addCity);
		request.setAttribute("Gender", gender);
		request.setAttribute("Race", race);
		request.setAttribute("Email", email);
		request.setAttribute("ContactNo", contactNo);
		request.setAttribute("AreaCode", areaCode);
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/Imal/updateVoterForm.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String oname = request.getParameter("oname");
		String nic = request.getParameter("nic");
		String dob = request.getParameter("dob");
		String addNo = request.getParameter("addNo");
		String addStreet = request.getParameter("addStreet");
		String addCity = request.getParameter("addCity");
		String gender = request.getParameter("gender");
		String race = request.getParameter("race");
		String email = request.getParameter("email");
		String contactNoString = request.getParameter("contactNo");
		String areaCodeString = request.getParameter("areaCode");
		
		VoterModel v1 = new VoterModel();
		PrintWriter out = response.getWriter();
		
		v1.setFname(fname);
		v1.setLname(lname);
		v1.setOname(oname);
		v1.setNic(nic);
		v1.setDob(dob);
		v1.setAddNo(addNo);
		v1.setAddStreet(addStreet);
		v1.setAddCity(addCity);
		v1.setGender(gender);
		v1.setRace(race);
		v1.setEmail(email);
		int contactNo = Integer.parseInt(request.getParameter("contactNo"));
		v1.setContactNo(contactNo);
		int areaCode = Integer.parseInt(request.getParameter("areaCode"));
		v1.setAreaCode(areaCode);
		
		ImalVoterServiceImpl update = new ImalVoterServiceImpl();
		
		update.updateVoter(v1);
		
		response.sendRedirect("/nops/ImalGetVoterServlet");
	}

}
