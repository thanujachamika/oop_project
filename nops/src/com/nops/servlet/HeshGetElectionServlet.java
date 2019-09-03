package com.nops.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nops.model.ElectionModel;
import com.nops.service.HeshService;
import com.nops.service.HeshServiceImpl;

/**
 * Servlet implementation class HeshGetElectionServlet
 */
@WebServlet("/HeshGetElectionServlet")
public class HeshGetElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeshGetElectionServlet() {
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
		String Eid = request.getParameter("Eid");
		
		HeshService h = new HeshServiceImpl();
		ElectionModel e = h.getElectionById(Eid);
		
		request.setAttribute("Elect", e);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Heshan/editElectionForm.jsp");
		dispatcher.forward(request, response);
	}

}
