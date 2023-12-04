package controllerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;
import model.GameDAO;

/**
 * Servlet implementation class AddGameServlet
 */
@WebServlet("/AddGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
	    String title = request.getParameter("title");
	    String genre = request.getParameter("genre");

	    try {
	        Game newGame = new Game(userName, title, genre);
	        GameDAO.instance.saveGame(newGame);
	        response.sendRedirect("index.jsp");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
