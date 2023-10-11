

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookDAO;
import model.Book;
import model.BookDAO;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		Book b1 = new Book(title, author);
		BookDAO.instance.save(b1);
		List<Book> bookList = BookDAO.instance.list();
		
		request.setAttribute("listOfBooks", bookList);
		request.getRequestDispatcher("display.jsp").forward(request, response);
		

	}

}
