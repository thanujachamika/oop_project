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
 * Servlet implementation class HeshAddElectionServlet
 */
@WebServlet("/HeshAddElectionServlet")
public class HeshAddElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeshAddElectionServlet() {
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
		
		int Eid = Integer.parseInt(request.getParameter("Eid"));
		String Ename = request.getParameter("Ename");
		String Date = request.getParameter("Date");
		int Ecycle = Integer.parseInt(request.getParameter("Ecycle"));

		ElectionModel e1 = new ElectionModel();
		
		e1.setEid(Eid);
		e1.setEname(Ename);
		e1.setDate(Date);
		e1.setEcycle(Ecycle);

		
		HeshService h = new HeshServiceImpl();
		h.addElections(e1);
		
		request.setAttribute("e1", e1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Heshan/ElectionTable.jsp");
		dispatcher.forward(request, response);
	}

}
