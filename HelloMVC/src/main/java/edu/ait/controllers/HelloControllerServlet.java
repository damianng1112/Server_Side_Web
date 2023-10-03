package edu.ait.controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import edu.ait.model.User;
	
/**
 * Servlet implementation class HelloControllerServlet
 */
@WebServlet("/HelloControllerServlet")
public class HelloControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		User user = new User (name, "unknown");
		request.setAttribute("user", user);
		request.getRequestDispatcher("ShowUser.jsp").forward(request, response);
	}

}
