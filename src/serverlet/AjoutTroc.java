package serverlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjoutTroc")
public class AjoutTroc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Controller c;

	public AjoutTroc() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");

		if (op.equals("ajoutTroc")) {
			// response.getWriter().println("<html><body>");
			// response.getWriter().println("ajout Personne ") ;
			// response.getWriter().println("</body></html>");

			String duree = request.getParameter("duree");
			String titre = request.getParameter("titre");
			String description = request.getParameter("description");
			String domaine = request.getParameter("categorie");
			String etat = request.getParameter("etat");
			String datedeb = request.getParameter("datedeb");
			String datefin = request.getParameter("datefin");

			// perso je ne vois pas comment faire pour récupérer les images
			// String files = request.getParameter("files") ;

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = null;
			Date date2 = null;
			try {
				date1 = format.parse(datedeb);
				date2 = format.parse(datefin);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String name = "aaa";

			try {
				boolean t = c.ajouterTroc(titre, duree, etat, domaine, date1, date2, name);

				if (t) {
					request.getRequestDispatcher("menu.html").forward(request, response);
				} else {
					request.getRequestDispatcher("register.html").forward(request, response);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			// request.getRequestDispatcher("menu.html").forward(request,
			// response);

			// response.getWriter().println("<html><body>");
			// response.getWriter().println(date1 ) ;
			// response.getWriter().println(date2 ) ;
			//
			// response.getWriter().println("</body></html>");

		}
		else if(op.equals("toutTroc"))
		{
			request.setAttribute("listeTrocsServ", c.listeTroc());
			request.getRequestDispatcher("toutTroc.jsp").forward(request, response);
		}
	}
}
