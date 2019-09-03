package com.nops.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nops.service.ThanujaService;
import com.nops.service.ThanujaServiceImpl;



/**
 * Servlet implementation class ThanujaDeletePPServlet
 */
@WebServlet("/ThanujaDeletePPServlet")
public class ThanujaDeletePPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanujaDeletePPServlet() {
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
		
		String id = request.getParameter("poliId");			
		
		ThanujaService pp = new ThanujaServiceImpl();
		pp.removePP(id);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Thanuja/adminPage2PartyTable.jsp");
		dispatcher.forward(request, response);
	}

}
