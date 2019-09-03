package com.nops.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nops.model.PoliticalParty;
import com.nops.service.ThanujaService;
import com.nops.service.ThanujaServiceImpl;


/**
 * Servlet implementation class ThanujaUpdatePPServlet
 */
@WebServlet("/ThanujaUpdatePPServlet")
public class ThanujaUpdatePPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanujaUpdatePPServlet() {
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
		
		PoliticalParty po = new PoliticalParty();
		String pid = request.getParameter("politiId");
		
		po.setPartyId(pid);
		po.setPartyLogo(request.getParameter("partyLogo"));
		po.setPartyName(request.getParameter("partyName"));
		po.setAbbreivation(request.getParameter("abbreivation"));
		po.setLeaderName(request.getParameter("ledName"));
		po.setSecName(request.getParameter("secName"));
		po.setOfficialContact(request.getParameter("offContact"));
		po.setOfficialEmail(request.getParameter("offEmail"));
		po.setAddressNo(request.getParameter("addNo"));
		po.setAddressStreet(request.getParameter("addStreet"));
		po.setAddressCity(request.getParameter("addCity"));
		
		ThanujaService tcw = new ThanujaServiceImpl();
		tcw.updatePoliticalParty(pid, po);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Thanuja/adminPage2PartyTable.jsp");
		dispatcher.forward(request, response);
	}

}
