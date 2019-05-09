package serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op") ; 
		
		if(op.equals("ajoutTroc")) {
//			response.getWriter().println("<html><body>");
//			response.getWriter().println("ajout Personne ") ;
//			response.getWriter().println("</body></html>");
			

			
			String duree = request.getParameter("duree") ; 
			String titre = request.getParameter("titre") ; 
			String description = request.getParameter("description") ; 
			String domaine = request.getParameter("categorie") ; 
			String etat = request.getParameter("etat") ; 
			
//			perso je ne vois pas comment faire pour récupérer les images 
//			String files = request.getParameter("files") ;
			
			
			c.ajouterTroc(titre,duree,etat,domaine);
			request.getRequestDispatcher("menu.html").forward(request, response);
			
//			
//			response.getWriter().println("<html><body>");
//			response.getWriter().println(duree + titre + description +categorie + etat ) ;
//			response.getWriter().println("</body></html>");

			

		}
	}
	}
