

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;
import model.HouseDAO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/HouseServlet")
public class HouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String owner = request.getParameter("owner");
		String address = request.getParameter("address");
		String numOfBedrooms = request.getParameter("numOfBedroom");
		House hNew = new House(owner, address, numOfBedrooms);
		HouseDAO.instance.save(hNew);
		List<House> houseList = HouseDAO.instance.list();
		
		request.setAttribute("listOfHouses", houseList);
		request.getRequestDispatcher("displayHouse.jsp").forward(request, response);
	}

}
