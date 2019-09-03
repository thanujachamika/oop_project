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
 * Servlet implementation class NuwUpdateCandidateServlet
 */
@SuppressWarnings("unused")
@WebServlet("/NuwUpdateCandidateServlet")
public class NuwUpdateCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuwUpdateCandidateServlet() {
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
		String nic = request.getParameter("updatecandidate");
		CandidateModel cm = new CandidateModel();
		cm.setFname(request.getParameter("cfname"));
		cm.setLname(request.getParameter("clname"));
		cm.setNic(nic);
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
		
		int status = cs.updateCandidate(cm, nic);
		if (status < 1) {
			request.setAttribute("error", "Error, Retry");
			request.getRequestDispatcher("/WEB-INF/views/Nuwanga/editCandidateForm.jsp").forward(request, response);
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Nuwanga/candidateTable.jsp");
		dispatcher.forward(request, response);
		
	}

}
