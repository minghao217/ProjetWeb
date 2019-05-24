<%@page import="model.Historique"%>
<%@page import="model.Troc"%>
<%@page import="serverlet.AjoutTroc"%>
<%@page import="serverlet.Controller"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>Afficher l'historique </title>
</head>
<body>
	<form action="AjoutTroc" method="post">
	
	<% String nomConnecte = (String) request.getAttribute("nomconnecte"); %> 
	    <div class="col-md-12">
        <h4>Historique de <%=nomConnecte %></h4>
        <div class="table-responsive">

                
              <table id="mytable" class="table table-bordred table-striped">
                   
                   <thead>
                   
                   <th>Troc</th>
                    <th>Date Debut</th>
                     <th>Date Fin</th>

                  
                   </thead>
    <tbody>


		<%
			
			Collection<Historique> listeHisto = (Collection<Historique>) request.getAttribute("listeHistoServ");
			for (Historique t : listeHisto) {
				//int id = p.getId();
				// String s = p.getNom() + " " + p.getPrenom() ; 

				Date datedebut = t.getDatedebut();
				Date datefin = t.getDatefin();
				String troc = t.getTroc().getTitle();
				String propr = t.getProprio().getNom();
				
				/* 				

								String nomEtudiant = t.getProprio().getNom(); */
								
		
								
			if (propr.equals(nomConnecte) )
			{
			
		%>

    <tr>
    <td><%=troc %></td>
    <td><%=datedebut %></td>
    <td><%=datefin %></td>
	</tr>


		<%
			} } 
		%>
		    </tbody>
    
</table>
</form>
</body>
</html>