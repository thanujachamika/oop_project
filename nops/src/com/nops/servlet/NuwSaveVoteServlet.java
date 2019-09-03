package com.nops.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nops.model.CastVoteModel;
import com.nops.service.NuwCastVoteService;
import com.nops.service.NuwCastVoteServiceImpl;

/**
 * Servlet implementation class NuwSaveVoteServlet
 */
@WebServlet("/NuwSaveVoteServlet")
public class NuwSaveVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuwSaveVoteServlet() {
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
		
		CastVoteModel cv = new CastVoteModel();
		cv.setPartyid(Integer.parseInt(request.getParameter("pid")));
		cv.setCandidateid(Integer.parseInt(request.getParameter("cid")));
		cv.setElectionid(Integer.parseInt(request.getParameter("eid")));
		cv.setVoterid(Integer.parseInt(request.getParameter("vid")));
		cv.setVoterareacode(Integer.parseInt(request.getParameter("vac")));
		
		NuwCastVoteService cvs = new NuwCastVoteServiceImpl();
		int status = cvs.addVote(cv);
		if (status < 1) {
			request.setAttribute("error", " --You Can Not Vote Again--   ");
			request.getRequestDispatcher("/WEB-INF/views/Nuwanga/voterPage.jsp").forward(request, response);
		}
		
		status = cvs.addCandidateVote(cv);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

}
