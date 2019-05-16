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

<title>Afficher les Troc Disponible</title>
</head>
<body>
	<form action="AjoutTroc" method="post">

		<section class="d-flex flex-column"> <nav
			class="navbar navbar-light navbar-expand-md sticky-top text-center"
			style="font-size: 26px;">
		<div class="container-fluid">
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navcol-1">
				<span class="sr-only">Toggle navigation</span><span
					class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navcol-1"
				style="padding: 10px; font-size: 20px;">
				<ul class="nav navbar-nav">
					<li class="nav-item" role="presentation"><a
						class="nav-link active shadow-sm" href="#"
						style="color: rgba(0, 0, 0, 0.9);">File</a></li>
					<li class="nav-item" role="presentation"><a
						class="nav-link shadow-sm active" href="#"
						style="color: rgba(0, 0, 0, 0.9);">Downloads</a></li>
					<li class="nav-item" role="presentation"><a
						class="nav-link shadow-sm active" href="#"
						style="color: rgba(0, 0, 0, 0.9);">Tool</a></li>
					<li class="nav-item" role="presentation"><a
						class="nav-link shadow-sm active" href="#"
						style="color: rgba(0, 0, 0, 0.9);">Help</a></li>
				</ul>
				<ul class="nav navbar-nav ml-auto">
					<li class="nav-item" role="presentation"><a
						class="nav-link text-center text-secondary d-flex"
						href="menu.html" target="_blank">Echange n7</a></li>
				</ul>
			</div>
		</div>
		</nav> </section>


		<%
			Collection<Troc> listeTroc = (Collection<Troc>) request.getAttribute("listeTrocsServ");
			for (Troc t : listeTroc) {
				//int id = p.getId();
				// String s = p.getNom() + " " + p.getPrenom() ; 
				String titre = t.getTitle();
				Date datedebut = t.getDatedebut();
				Date datefin = t.getDatefin();
				String domaine = t.getDomaine().getNom();
				
				/* 				

								String nomEtudiant = t.getProprio().getNom(); */
		%>

    <hr>
    <div class="div1">
        <div class="container">
            <div class="row">
                <div class="col-2 d-inline float-none align-self-center"><img class="border rounded" src="http://simpleicon.com/wp-content/uploads/account.png" style="width: 128px;"></div>
                <div class="col-3">
                    <p><strong><%=titre %></strong></p>
                    <p>Disponibilité  :<br> <%=datedebut %> <br> <%=datefin %> </p>
                </div>
                <div class="col-4 text-center justify-content-center align-self-center">
                    <p>Domaine : <%=domaine %></strong></p>
                    <p>Proprietaire : Selim </p>
                </div>
                <div class="col-2 align-self-center"><button class="btn btn-primary" type="button" style="width: 150px;height: 36px;">Commander <i class="icon ion-ios-arrow-thin-down"></i></button></div>
            </div>
        </div>
    </div>
    <hr>


		<%
			}
		%>

		<input type="submit" value="Associer"> <input type="hidden"
			value="choixasso" name="op">
	</form>
</body>
</html>