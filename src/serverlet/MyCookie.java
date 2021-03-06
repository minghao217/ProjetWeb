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



import model.Adresse;
import model.Etudiant;
@WebServlet("/MyCookie")
public class MyCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	private Controller c; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**String op = request.getParameter("op");
		//response.getWriter().println("<html><body>Hello World !</body></html>");
	   
		//sauvegarder les cookies (nom,password)
		 if (op.equals("LOGIN")) 
		{
			String nom = request.getParameter("Username");
			String prenom = request.getParameter("Password");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<html><body>Hello Worldqqqqq!</body></html>");
			
			Cookie name = new Cookie("name",
	                URLEncoder.encode(request.getParameter("Username"), "UTF-8")); // 中文转码
	        Cookie password = new Cookie("password",
	                      request.getParameter("Password"));
	        name.setMaxAge(3600);
	        password.setMaxAge(3600);
	        response.addCookie(name);
	        response.addCookie(password);
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        String title = "设置 Cookie 实例";
	        String docType = "<!DOCTYPE html>\n";
	        out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>username：</b>："
	                + request.getParameter("Username") + "\n</li>" +
	                "  <li><b>password：</b>："
	                + request.getParameter("Password") + "\n</li>" +
	                "</ul>\n" +
	                "</body></html>");
	        
			//request.getRequestDispatcher("index.html").forward(request,response);
		}**/
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String nom = request.getParameter("Username");
		String password = request.getParameter("Password");
		if (op.equals("LOGIN")) 
		{
			Cookie cookie = null;
	        Cookie[] cookies = null;
	        // obtenir cookies
	        cookies = request.getCookies();
	         
	         // 设置响应内容类型
	         response.setContentType("text/html;charset=UTF-8");
	    
	         PrintWriter out = response.getWriter();
	         String title = "Delete Cookie Example";
	         String docType = "<!DOCTYPE html>\n";
	         out.println(docType +
	                   "<html>\n" +
	                   "<head><title>" + title + "</title></head>\n" +
	                   "<body bgcolor=\"#f0f0f0\">\n" );
	         
	         
	          if(  cookies != null ){
	            out.println("<h2>Cookie 名称和值</h2>");
	            out.println("key ："+cookies.length);
	            for (int i = 0; i < cookies.length; i++){
	               cookie = cookies[i];
	               if(cookie.getName() == nom || cookie.getName() == password) {
	            	   out.print("key：" + cookie.getName( ) + "，");
		               out.print("value：" +  URLDecoder.decode(cookie.getValue(), "utf-8") +" <br/>");
		               
	               }
	               else{
	            	   

	  	        	 Cookie nameCookie = new Cookie("name",
	  	 	                URLEncoder.encode(request.getParameter("Username"), "UTF-8")); // 中文转码
	  	 	        Cookie passwordCookie = new Cookie("password",
	  	 	                      request.getParameter("Password"));
	  	 	        nameCookie.setMaxAge(3600);
	  	 	       passwordCookie.setMaxAge(3600);
	  	 	        response.addCookie(nameCookie);
	  	 	        response.addCookie(passwordCookie);
	  	             out.println(
	  	               "<h2 class=\"tutheader\">No Cookie founds</h2>");
	  	         }
	  	        
	           
	        	 
		}
	          }
	          else{
           	   

	  	        	 Cookie nameCookie = new Cookie("name",
	  	 	                URLEncoder.encode(request.getParameter("Username"), "UTF-8")); // 中文转码
	  	 	        Cookie passwordCookie = new Cookie("password",
	  	 	                      request.getParameter("Password"));
	  	 	        nameCookie.setMaxAge(3600);
	  	 	       passwordCookie.setMaxAge(3600);
	  	 	        response.addCookie(nameCookie);
	  	 	        response.addCookie(passwordCookie);
	  	             out.println(
	  	               "<h2 class=\"tutheader\">No Cookie founds</h2>");
	  	         }
		}
	}
		}
