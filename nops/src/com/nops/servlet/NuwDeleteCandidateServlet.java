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
 * Servlet implementation class NuwDeleteCandidateServlet
 */
@SuppressWarnings("unused")
@WebServlet("/NuwDeleteCandidateServlet")
public class NuwDeleteCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuwDeleteCandidateServlet() {
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
		
		String nic = request.getParameter("deletecandidate");
		
		NuwCandidateService cs = new NuwCandidateServiceImpl();
		
		cs.deleteCandidate(nic);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Nuwanga/candidateTable.jsp");
		dispatcher.forward(request, response);
	}

}
