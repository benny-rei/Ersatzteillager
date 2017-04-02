package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Model.DBManager;
import Model.Teile;


/**
 * Servlet implementation class TeileServlet
 */
@WebServlet("/TeileServlet")
public class TeileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeileServlet() {
        super();
        // TODO Auto-generated constructor stub
        //heile du geile
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		try {
			String bez = (String) request.getParameter("bezeichnung");
			System.out.println("Bez:" +bez);
			 
			//DBManager db = new DBManager();
			//ArrayList<Teile> teile = db.searchTeile(bez);
			ArrayList<Teile> teile = new ArrayList<Teile>();
			teile.add(new Teile(1,2,"golf 4er; golf 5er", 500, true, "Ölwanne"));
			
			for(Teile t : teile){
				System.out.println("Teil: "+t);
			}
			
			HttpSession sess = request.getSession(true);
			
			sess.setAttribute("Teile", teile);
			//db.close();
			response.sendRedirect("Teile.jsp");
		} catch (Exception e1) {
			e1.printStackTrace();
			response.sendRedirect("Teile.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
