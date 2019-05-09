package serverlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Adresse;
import model.Etudiant;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB 
	private Controller c; 
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		//response.getWriter().println("<html><body>Hello World !</body></html>");
     if (op.equals("New")){   	   
 	   String firstName = request.getParameter("Firstname");
 	   String familyName = request.getParameter("Familytname");
 	   String rue = request.getParameter("Address"); 
 	   String mail = request.getParameter("email"); 
 	   String mdp = request.getParameter("password"); 
 	   String gender = request.getParameter("gender"); 
 	   String level = request.getParameter("level"); 
 	  
 	   
 	   Etudiant etu = new Etudiant(familyName,firstName, mail,"0666677"); 
 	   Adresse adr = new Adresse(rue); 
 	   etu.setGender(gender);
 	   etu.setMdp(mdp);
 	   etu.setGender(gender);
 	   //c.ajouterEtudiant(etu, adr);
 	     if (c.findByName(familyName) != null){
 		  request.getRequestDispatcher("RegisterError.html").forward(request,response);
 	   } 
 	    else {
 		  c.ajouterEtudiant(etu, adr);
 		  request.getRequestDispatcher("Register.html").forward(request,response);;
 		 //response.getWriter().println("<html><body>Ajout</body></html>");
 	   }

		 }
	    
	    else {
	    	response.getWriter().println("<html><body>Ajout</body></html>");
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
