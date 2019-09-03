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
 * Servlet implementation class ImalRegisterVoter
 */
@WebServlet("/ImalRegisterVoter")
public class ImalRegisterVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImalRegisterVoter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served aasdt: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
				PrintWriter out = response.getWriter();
				
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
				
				boolean error =  false;
				
				VoterModel v1 = new VoterModel();
				
				if(fname == null || fname.isEmpty()) {
					error = true;
					request.setAttribute("FnameError", "Please enter first name!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				} 
				else {
					request.setAttribute("Fname", request.getParameter("fname"));
				}

				if (lname == null || lname.isEmpty()) {
					error = true;
					request.setAttribute("LnameError", "Please enter last name!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
					}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if (oname == null || oname.isEmpty()) {
					error = true;
					request.setAttribute("OnameError", "Please enter middle name!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if (nic == null || nic.isEmpty()) {
					error = true;
					request.setAttribute("nicError", "Please enter NIC!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
					
				}
				else {
					
					int status = 0;
					
			 ImalVoterServiceImpl read = new ImalVoterServiceImpl(); 
			 status = read.readVoterID(request.getParameter("nic"));
			 
					if(status > 0) {
						error = true;
						request.setAttribute("nicExists", "User already exists in Database!");
					}
					else {
						request.setAttribute("Fname", request.getParameter(fname));
					}
					
				}
				

				if (dob == null || dob.isEmpty()) {
					error = true;
					request.setAttribute("dobError", "Please enter Date of Birth!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if (addNo == null || addNo.isEmpty()) {
					error = true;
					request.setAttribute("addLine1Error", "Please enter Address Line 1!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if (addStreet == null || addStreet.isEmpty()) {
					error = true;
					error = true;
					request.setAttribute("addLine2Error", "Please enter Address Line 2!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if (addCity == null || addCity.isEmpty()) {
					error = true;
					error = true;
					request.setAttribute("addLine3Error", "Please enter Address Line 3!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if (gender == null || gender.isEmpty()) {
					error = true;
					error = true;
					request.setAttribute("genderError", "Please specify your gender!!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if (race == null || race.isEmpty()) {
					error = true;
					error = true;
					request.setAttribute("raceError", "Please specify your race!!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if (email == null || email.isEmpty()) {
					error = true;	
					error = true;
					request.setAttribute("emailError", "Please enter a valid Email!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
					}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if ((contactNoString.trim().length() == 0)) {
					error = true;
					
					request.setAttribute("contactNoError", "Please enter a valid contact number!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				if ((areaCodeString.trim().length() == 0)) {
					error = true;
					
					request.setAttribute("areaCodeError", "Please set your area code!");
					//request.getRequestDispatcher("Views/JSP/registerVoterView.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Fname", request.getParameter(fname));
				}

				
				if(error == true) {
					request.getRequestDispatcher("/WEB-INF/views/Imal/registerVoterForm.jsp").forward(request, response);
					
				}
				else {
					
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
					
				ImalVoterServiceImpl db = new ImalVoterServiceImpl();
				
				int status = db.addVoter(v1);
				
				if (status > 0) {
					
					out.print("Record saved successfully!");  
					

					response.sendRedirect("/nops/ImalGetVoterServlet");
				
					
				} else {
					
					out.println("Sorry! unable to save record");  

					}
				}
		
		
	}

}
