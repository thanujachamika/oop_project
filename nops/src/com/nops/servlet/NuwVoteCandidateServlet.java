package com.nops.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nops.service.NuwCastVoteService;
import com.nops.service.NuwCastVoteServiceImpl;

/**
 * Servlet implementation class NuwVoteCandidateServlet
 */
@WebServlet("/NuwVoteCandidateServlet")
public class NuwVoteCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuwVoteCandidateServlet() {
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
		String pid = request.getParameter("pid");
		String vid = request.getParameter("vid");
		String vac = request.getParameter("vac");
		String eid = request.getParameter("eid");
		
		request.setAttribute("vid", vid);
		request.setAttribute("eid", eid);
		request.setAttribute("vac", vac);
		request.setAttribute("pid", pid);
		request.getRequestDispatcher("/WEB-INF/views/Nuwanga/castVoteTable2.jsp").forward(request, response);
	}

}
