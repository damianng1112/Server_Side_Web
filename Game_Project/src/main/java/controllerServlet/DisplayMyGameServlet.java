package controllerServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Game;
import model.GameDAO;
import model.User;

/**
 * Servlet implementation class DisplayMyGameServlet
 */
@WebServlet("/DisplayMyGameServlet")
public class DisplayMyGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayMyGameServlet() {
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
		HttpSession s = request.getSession();
		User loggedInUser = (User) s.getAttribute("userInfo");
		List<Game> userGames = null;
		try {
	        userGames = GameDAO.instance.listByUser(loggedInUser);
	        request.setAttribute("userGames", userGames);
	        request.getRequestDispatcher("displayMyGames.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
