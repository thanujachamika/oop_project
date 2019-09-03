package com.nops.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NuwVotePartyServlet
 */
@WebServlet("/NuwVotePartyServlet")
public class NuwVotePartyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuwVotePartyServlet() {
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
		String vid = request.getParameter("vid");
		String vac = request.getParameter("vac");
		String eid = request.getParameter("eid");
		
		request.setAttribute("eid", eid);
		request.setAttribute("vid", vid);
		request.setAttribute("vac", vac);
		request.getRequestDispatcher("/WEB-INF/views/Nuwanga/castVoteTable1.jsp").forward(request, response);
	}

}
