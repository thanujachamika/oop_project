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
 * Servlet implementation class NuwGetCandidateServlet
 */
@WebServlet("/NuwGetCandidateServlet")
public class NuwGetCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuwGetCandidateServlet() {
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
		String nic = request.getParameter("nic");
		NuwCandidateService cs = new NuwCandidateServiceImpl();
		CandidateModel cm = cs.getCandidateDetails(nic);
		
		request.setAttribute("cm", cm);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Nuwanga/editCandidateForm.jsp");
		dispatcher.forward(request, response);
	}

}
