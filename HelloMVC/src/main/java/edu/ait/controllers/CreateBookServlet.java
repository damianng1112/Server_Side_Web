package edu.ait.controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import edu.ait.model.Book;
	
/**
 * Servlet implementation class CreateBookServlet
 */
@WebServlet("/CreateBookServlet")
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		Book book = new Book (title, author);
		request.setAttribute("book", book);
		request.getRequestDispatcher("ShowBook.jsp").forward(request, response);
	}

}
