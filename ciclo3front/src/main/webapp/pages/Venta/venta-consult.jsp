<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">
</link>
<link rel="stylesheet" href="../styles/styles.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/"><img
				src="img/logo.png" height="30" width="41"></a>

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
					<li class="nav-item"><a class="nav-link" href="#"><i
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


	<div class="jumbotron">
		<div class="container">
			<div class="row row-content">
				<div class="col-12 col-md-9">
					<div class="card">
						<div class="card-header">
							<h3>Cliente:</h3>
						</div>
						<div class="card-body">
							<form action="searchClient" method="post" id="formClient">
								<div class="form-group row">
									<label for="cedula" class="col-md-2 col-form-label">Cedula
										Cliente</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="cedula"
											name="cedula" placeholder="Cedula">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-10">
										<button id="buscarCliente" type="submit"
											class="btn btn-primary" value="BuscarCliente">Send
											Feedback</button>
									</div>
								</div>

								<div role="alert" id="alertCliente">
									<h4 class="alert-heading" id="msgCliente"></h4>
								</div>

								<div class="form-group row">
									<label for="nombre" class="col-md-2 col-form-label">Nombre
										del Cliente Consultado</label>
									<div class="col-md-4">
										<input type="text" class="form-control"
											id="inputClienteEncontrado" name="nombre"
											placeholder="Nombre" value="" readonly>
									</div>
								</div>

								<div class="form-group row">
									<label for="cedula" class="col-md-2 col-form-label">Cedula
										del Cliente Consultado</label>
									<div class="col-md-4">
										<input type="text" class="form-control"
											id="inputClienteEncontrado2" name="cedula"
											placeholder="Cedula" value="" readonly>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>


			<div class="row row-content">
				<div class="col-12 col-md-9">
					<div class="card">
						<div class="card-header">
							<h3>Cliente:</h3>
						</div>
						<div class="card-body">
							<form action="searchProduct3" method="post" id="formProduct1">




								<div class="form-group row">
									<label for="cod1" class="col-md-2 col-form-label">Cedula
										Cliente</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="cod1"
											name="cod1" placeholder="cod1">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-10">
										<button id="buscarProducto1" type="submit"
											class="btn btn-primary" value="BuscarProducto1">Send
											Feedback</button>
									</div>
								</div>

								<div role="alert" id="alertP1">
									<h4 class="alert-heading" id="msgP1"></h4>
								</div>

								<div class="form-group row">
									<label for="nomCod1" class="col-md-2 col-form-label">Nombre
										Producto</label>
									<div class="col-md-4">
										<input type="text" class="form-control" id="nomCod1"
											name="nomCod1" placeholder="nomCod1" value="" readonly>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-4">
										<input type="hidden" class="form-control" id="valor1"
											name="valor1" placeholder="valor1" value="" readonly>
									</div>
								</div>

								<div class="form-group row">
									<label for="can1" class="col-md-2 col-form-label">Cantidad:</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="can1"
											name="can1" placeholder="can1">
									</div>
								</div>
								<div class="form-group row">
									<label for="val1" class="col-md-2 col-form-label">Valor
										Total:</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="val1"
											name="val1" placeholder="val1" readonly>
									</div>
								</div>


							</form>
						</div>
					</div>
				</div>
			</div>


			<div class="row row-content">
				<div class="col-12 col-md-9">
					<div class="card">
						<div class="card-header">
							<h3>Cliente:</h3>
						</div>
						<div class="card-body">
							<form action="searchProduct2" method="post" id="formProduct2">




								<div class="form-group row">
									<label for="cod2" class="col-md-2 col-form-label">Cedula
										Cliente</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="cod2"
											name="cod2" placeholder="cod2">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-10">
										<button id="buscarProducto2" type="submit"
											class="btn btn-primary" value="BuscarProducto2">Send
											Feedback</button>
									</div>
								</div>

								<div role="alert" id="alertP2">
									<h4 class="alert-heading" id="msgP2"></h4>
								</div>

								<div class="form-group row">
									<label for="nomCod2" class="col-md-2 col-form-label">Nombre
										Producto</label>
									<div class="col-md-4">
										<input type="text" class="form-control" id="nomCod2"
											name="nomCod2" placeholder="nomCod2" value="" readonly>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-4">
										<input type="hidden" class="form-control" id="valor2"
											name="valor2" placeholder="valor2" value="" readonly>
									</div>
								</div>

								<div class="form-group row">
									<label for="can2" class="col-md-2 col-form-label">Cantidad:</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="can2"
											name="can2" placeholder="can2">
									</div>
								</div>
								<div class="form-group row">
									<label for="val2" class="col-md-2 col-form-label">Valor
										Total:</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="val2"
											name="val2" placeholder="val2" readonly>
									</div>
								</div>


							</form>
						</div>
					</div>
				</div>
			</div>


			<div class="row row-content">
				<div class="col-12 col-md-9">
					<div class="card">
						<div class="card-header">
							<h3>Cliente:</h3>
						</div>
						<div class="card-body">
							<form action="searchProduct" method="post" id="formProduct3">




								<div class="form-group row">
									<label for="cod3" class="col-md-2 col-form-label">Cedula
										Cliente</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="cod3"
											name="cod3" placeholder="cod3">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-10">
										<button id="buscarProducto3" type="submit"
											class="btn btn-primary" value="BuscarProducto3">Send
											Feedback</button>
									</div>
								</div>

								<div role="alert" id="alertP3">
									<h4 class="alert-heading" id="msgP3"></h4>
								</div>

								<div class="form-group row">
									<label for="nomCod3" class="col-md-2 col-form-label">Nombre
										Producto</label>
									<div class="col-md-4">
										<input type="text" class="form-control" id="nomCod3"
											name="nomCod3" placeholder="nomCod3" value="" readonly>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-4">
										<input type="hidden" class="form-control" id="valor3"
											name="valor3" placeholder="valor3" value="" readonly>
									</div>
								</div>

								<div class="form-group row">
									<label for="can3" class="col-md-2 col-form-label">Cantidad:</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="can3"
											name="can3" placeholder="can3">
									</div>
								</div>
								<div class="form-group row">
									<label for="val3" class="col-md-2 col-form-label">Valor
										Total:</label>
									<div class="col-md-4">
										<input type="number" class="form-control" id="val3"
											name="val3" placeholder="val3" readonly>
									</div>
								</div>


							</form>
						</div>
					</div>
				</div>
			</div>



			<button id="consultar" type="submit" class="btn btn-primary">
				Send Feedback</button>
		</div>
	</div>

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
			<div class="row justify-content-center">
				<div class="col-auto">
					<p>© Copyright 2021 Grupo 8 - Ciclo 3. Mision TIC</p>
				</div>
			</div>
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script src="../js/jquery-3.6.0.min.js"></script>
	<script src="../js/venta.js"></script>
</body>
</html>