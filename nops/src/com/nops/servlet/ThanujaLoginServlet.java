package com.nops.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nops.model.UserModel;
import com.nops.model.VoterModel;
import com.nops.service.ThanujaService;
import com.nops.service.ThanujaServiceImpl;

/**
 * Servlet implementation class ThanujaLoginServlet
 */
@WebServlet("/ThanujaLoginServlet")
public class ThanujaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanujaLoginServlet() {
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
		
		HttpSession session = request.getSession();
		session.removeAttribute("errorMessage");
		
		final String  errorMessage= "<div style=\"text-align: center\"><i class=\"fa fa-warning\" style=\"color:red\"></i>&nbsp;Invalid Login,Please try again</div>";
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//which link user clicked
		String from = (String) session.getAttribute("from");
		
		//check user clicked link null or not, if it is null link set to homepage 
		if(from == null) {
			from = "index.jsp";
		}else {
			session.removeAttribute("from");
		}
		
		if(username != null && password != null) {
			ThanujaService t = new ThanujaServiceImpl();
			VoterModel v;
			
			//assign database result to u UserModel object
			v = t.login(username, password);
			
			if(v != null) {
			 	//UserModel u object not null,then store user details into session attribute
//				session.setAttribute("loggedUser", v);
//				response.sendRedirect(from);
				request.setAttribute("vid", v.getVoterId());
				request.setAttribute("vac", v.getAreaCode());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Nuwanga/voterPage.jsp");
				dispatcher.forward(request, response);
			}
			else {
				//if UserModel type object is null forward error message
				request.setAttribute("errorMessage", errorMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Thanuja/login.jsp");
		        dispatcher.forward( request, response);
			}
		}
	}

}
