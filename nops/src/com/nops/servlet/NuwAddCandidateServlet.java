package com.nops.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nops.model.CandidateModel;
import com.nops.service.NuwCandidateService;
import com.nops.service.NuwCandidateServiceImpl;

/**
 * Servlet implementation class NuwAddCandidateServlet
 */
@WebServlet("/NuwAddCandidateServlet")
public class NuwAddCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuwAddCandidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		CandidateModel cm = new CandidateModel();
		cm.setFname(request.getParameter("cfname"));
		cm.setLname(request.getParameter("clname"));
		cm.setNic(request.getParameter("cnic"));
		cm.setDob(request.getParameter("cdob"));
		cm.setCandidatePartyID(Integer.parseInt(request.getParameter("cpid")));
		cm.setElectionID(Integer.parseInt(request.getParameter("ceid")));
		cm.setAreaCode(Integer.parseInt(request.getParameter("careacode")));
		cm.setGender(request.getParameter("cgender"));
		cm.setRace(request.getParameter("crace"));
		cm.setAddNo(request.getParameter("caddno"));
		cm.setAddStreet(request.getParameter("caddstreet"));
		cm.setAddCity(request.getParameter("caddcity"));
		cm.setContactNo(Integer.parseInt(request.getParameter("ccontactno")));
		cm.setEmail(request.getParameter("cemail"));
		
		NuwCandidateService cs = new NuwCandidateServiceImpl();
		int status = cs.registerCandidate(cm);
		if (status < 1) {
			request.setAttribute("error", "NIC Already Exsist");
			request.getRequestDispatcher("/WEB-INF/views/Nuwanga/registerCandidateForm.jsp").forward(request, response);
		}
		
		request.setAttribute("cm", cm);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Nuwanga/candidateTable.jsp");
		dispatcher.forward(request, response);
		
	}
	

}
