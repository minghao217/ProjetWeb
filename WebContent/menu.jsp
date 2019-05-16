<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<div class="nav-side-menu">
	<div class="brand">
	
		<%= request.getAttribute("nom")
		%>
		
		<img src= "./images/test.jpg"/>
	</div>
	<i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse"
		data-target="#menu-content"></i>

	<div class="menu-list">

		<ul id="menu-content" class="menu-content collapse out">
			<li><a href="#"> <i class="fa fa-dashboard fa-lg"></i>
					Dashboard
			</a></li>

			<li data-toggle="collapse" data-target="#products"
				class="collapsed active"><a href="#"><i
					class="fa fa-gift fa-lg"></i> Ajouter un Troc <span class="arrow"></span></a>
			</li>
			<ul class="sub-menu collapse" id="products">
				<li class="active"><a href="#">CSS3 Animation</a></li>
				<li><a href="#">General</a></li>
				<li><a href="#">Buttons</a></li>
				<li><a href="#">Tabs & Accordions</a></li>
				<li><a href="#">Typography</a></li>
				<li><a href="#">FontAwesome</a></li>
				<li><a href="#">Slider</a></li>
				<li><a href="#">Panels</a></li>
				<li><a href="#">Widgets</a></li>
				<li><a href="#">Bootstrap Model</a></li>
			</ul>


			<li data-toggle="collapse" data-target="#service" class="collapsed">
				<a href="#"><i class="fa fa-globe fa-lg"></i> Voir la liste des
					offres <span class="arrow"></span></a>
			</li>
			<ul class="sub-menu collapse" id="service">
				<li>Domaine 1</li>
				<li>Domaine 2</li>
				<li>Domaine 3</li>
			</ul>


			<li data-toggle="collapse" data-target="#new" class="collapsed">
				<a href="#"><i class="fa fa-car fa-lg"></i> Consulter Historique
					<span class="arrow"></span></a>
			</li>
			<ul class="sub-menu collapse" id="new">
				<li>New New 1</li>
				<li>New New 2</li>
				<li>New New 3</li>
			</ul>


			<li><a href="#"> <i class="fa fa-user fa-lg"></i> Profile
			</a></li>

			<li><a href="#"> <i class="fa fa-users fa-lg"></i> Users
			</a></li>
		</ul>
	</div>
</div>


</body>
</html>