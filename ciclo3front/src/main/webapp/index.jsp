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
<link rel="stylesheet" href="Styles/styles.css">
<meta charset="utf-8">
<title>Test</title>
</head>
<body>
	<header>
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
						<li class="nav-item"><a class="nav-link" href="#"><i
								class='fas fa-people-carry'></i> Proveedores</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class='fas fa-store-alt'></i> Productos</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class='fas fa-dollar-sign'></i> Ventas</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class='fas fa-clipboard-list'></i> Reportes</a></li>
					</ul>
					<form class="d-flex">
						<span class="navbar-text"> <a href="<%=request.getContextPath()%>/LoginServlet/login"> <i
								class='fas fa-sign-in-alt'></i> Login
						</a>
						</span>
					</form>
				</div>
			</div>
		</nav>
	</header>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
</body>
</html>