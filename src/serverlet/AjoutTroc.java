package serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
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
			
			String path ="./images/"+ request.getParameter("image"); 

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
			
			
			Cookie cookie = null; 
	        Cookie[] cookies = request.getCookies();
	        String name=null; 
	        if(  cookies != null ){  
	            for (int i = 0; i < cookies.length; i++){
	               cookie = cookies[i];
	               if (cookie.getName().equals("name")){
	            	   name = cookie.getValue(); 
	               }              
	            }}
	        else {}

//			String name = "aaa";

			try {
				boolean t = c.ajouterTroc(titre, duree, etat, domaine, date1, date2, name , path);

				if (t) {
					request.getRequestDispatcher("menu.jsp").forward(request, response);
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
		else if(op.equals("historique"))
		{
			Cookie cookie = null; 
	        Cookie[] cookies = request.getCookies();
	        String name=null; 
	        if(  cookies != null ){  
	            for (int i = 0; i < cookies.length; i++){
	               cookie = cookies[i];
	               if (cookie.getName().equals("name")){
	            	   name = cookie.getValue(); 
	               }              
	            }}
	        else {}
	        
	        request.setAttribute("nomconnecte", name);
			request.setAttribute("listeHistoServ", c.listeHistorique());
			request.getRequestDispatcher("listeHisto.jsp").forward(request, response);
		}
		else if(op.equals("commander"))
		{
			
			String idtroc = request.getParameter("cmd");
			
			
			Cookie cookie = null; 
	        Cookie[] cookies = request.getCookies();
	        String name=null; 
	        if(  cookies != null ){  
	            for (int i = 0; i < cookies.length; i++){
	               cookie = cookies[i];
	               if (cookie.getName().equals("name")){
	            	   name = cookie.getValue(); 
	               }              
	            }}
	        else {}
	        
	        c.commander(name,idtroc);
	        request.getRequestDispatcher("menu.jsp").forward(request, response);
	        
			
		}
		
	}
}
