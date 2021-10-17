<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">
</link>
<link rel="stylesheet" href="styles/styles.css">
<meta charset="utf-8">
<title>Tienda Generica</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><img src="img/logo.png"
				height="30" width="41"></a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#Navbar"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="Navbar">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						href="<%=request.getContextPath()%>/UsuarioServlet/list"><i
							class='fas fa-user'></i> Usuarios</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/ClienteServlet/list"><i
							class='fas fa-users'></i> Clientes</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/ProveedorServlet/list"><i
							class='fas fa-people-carry'></i> Proveedores</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/ProductoServlet/detail"><i
							class='fas fa-store-alt'></i> Productos</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/VentaServlet/venta"><i
							class='fas fa-dollar-sign'></i> Ventas</a></li>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class='fas fa-clipboard-list'></i> Reportes</a></li>
				</ul>
				<form class="d-flex">
					<a class="navbar-text"
						href="<%=request.getContextPath()%>/UsuarioServlet/new">
						<button type="button" class="btn btn-outline-secondary btn-sm">Crear</button>
					</a> <span class="navbar-text"> <a
						href="<%=request.getContextPath()%>/LoginServlet/login"> <i
							class='fas fa-sign-in-alt'></i> Login
					</a>
					</span>
				</form>
			</div>
		</div>
	</nav>


	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-7 col-sm-5">
					<h5>Integrantes</h5>
					<address>
						Proyecto Ciclo 3 Grupo 8<br> <i class="fa fa-user-plus fa-lg"></i>:
						Juan David Lozano Moreno <br> <i
							class="fa fa-user-times fa-lg"></i>: Brayan Alexis Villamizar
						Montañez:<br> <i class="fa fa-user-times fa-lg"></i>: Brandon
						sneyder Urbano Salamanca<br> <i
							class="fa fa-user-times fa-lg"></i>: William Suárez Escobar<br>
						<i class="fa fa-envelope fa-lg"></i>: <a
							href="mailto:confusion@food.net">jd.lozanom@uniandes.edu.co</a>
					</address>
				</div>
				<div class="col-12 col-sm-4 align-self-center">
					<div class="text-center">
						<a class="btn btn-social-icon btn-google"
							href="http://google.com/+"><i class="fa fa-google-plus"></i></a>
						<a class="btn btn-social-icon btn-facebook"
							href="http://www.facebook.com/profile.php?id="><i
							class="fa fa-facebook"></i></a> <a
							class="btn btn-social-icon btn-linkedin"
							href="http://www.linkedin.com/in/"><i class="fa fa-linkedin"></i></a>
						<a class="btn btn-social-icon btn-twitter"
							href="http://twitter.com/"><i class="fa fa-twitter"></i></a> <a
							class="btn btn-social-icon btn-google" href="http://youtube.com/"><i
							class="fa fa-youtube"></i></a> <a class="btn btn-social-icon"
							href="mailto:"><i class="fa fa-envelope-o"></i></a>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
</body>
</html>