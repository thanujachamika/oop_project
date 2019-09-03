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
 * Servlet implementation class ThanujaAddPP
 */
@WebServlet("/ThanujaAddPP")
public class ThanujaAddPP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanujaAddPP() {
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
		
		response.setContentType("text/html");
		
		String partyLogo = request.getParameter("partyLogo");
		String partyName = request.getParameter("partyName");
		String abbreivation = request.getParameter("abbreivation");
		String ledName = request.getParameter("ledName");
		String secName = request.getParameter("secName");
		String offContact = request.getParameter("offContact");
		String offEmail = request.getParameter("offEmail");
		String addNo = request.getParameter("addNo");
		String addStreet = request.getParameter("addStreet");
		String addCity = request.getParameter("addCity");
		
		PoliticalParty p1 = new PoliticalParty();
		
		p1.setPartyLogo(partyLogo);
		p1.setPartyName(partyName);
		p1.setAbbreivation(abbreivation);
		p1.setLeaderName(ledName);
		p1.setSecName(secName);
		p1.setOfficialContact(offContact);
		p1.setOfficialEmail(offEmail);
		p1.setAddressNo(addNo);
		p1.setAddressStreet(addStreet);
		p1.setAddressCity(addCity);
		
		ThanujaService th = new ThanujaServiceImpl();
		th.addPoliticalParty(p1);
		
		request.setAttribute("p1", p1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Thanuja/adminPage2PartyTable.jsp");
		dispatcher.forward(request, response);
	}

}
