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
 * Servlet implementation class HeshUpdateElectionServlet
 */
@WebServlet("/HeshUpdateElectionServlet")
public class HeshUpdateElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeshUpdateElectionServlet() {
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
		ElectionModel em = new ElectionModel();
		String eid = request.getParameter("e");		
		em.setEid(Integer.parseInt(eid));
		em.setEname(request.getParameter("Ename"));
		em.setDate(request.getParameter("Date"));
		em.setEcycle(Integer.parseInt(request.getParameter("Ecycle")));
		
		HeshService hs= new HeshServiceImpl();
	    int status = hs.updateElection(eid, em);
	    
	    if(status < 0) {
	    	
	    	request.setAttribute("error", "error,Retry");
	    	request.getRequestDispatcher("/WEB-INF/views/Heshan/editElectionForm.jsp");
	    	
	    }
	   
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Heshan/ElectionTable.jsp");
		dispatcher.forward(request, response);
	}

}
