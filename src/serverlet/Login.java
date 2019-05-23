package serverlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Adresse;
import model.Etudiant;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB 
	private Controller c; 
    public Login() {
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
		doGet(request, response);
		String op = request.getParameter("op");
		//response.getWriter().println("<html><body>Hello World !</body></html>");
		if (op.equals("LOGIN")){   	   
	 	   String nom = request.getParameter("Username");
	 	   String password = request.getParameter("Password");
	 	   Etudiant e = c.findByName(nom);
	 	   
	 	   
	 	   if (e != null && e.getMdp().equals(password) ){
	 		   
//	 		   Cookie nameCookie = new Cookie("name",
//	 	                URLEncoder.encode(request.getParameter("Username"), "UTF-8")); // 中文转码
	 		   Cookie nameCookie = new Cookie("name",nom); // 中文转码
	 	       Cookie passwordCookie = new Cookie("password",password);
	 	       nameCookie.setMaxAge(3600);
	 	       passwordCookie.setMaxAge(3600);
	 	       response.addCookie(nameCookie);
	 	       response.addCookie(passwordCookie);
	 	       request.setAttribute("nom", nom);
	 	       request.setAttribute("path", e.getpath());
	 	       request.getRequestDispatcher("menu.jsp").forward(request,response);
	 	   } 
	 	   else {
	 		   request.getRequestDispatcher("Register.html").forward(request,response);
	 	   }

		}
	    else {
	    	response.getWriter().println("<html><body>Ajout</body></html>");
	    }
	}

}
