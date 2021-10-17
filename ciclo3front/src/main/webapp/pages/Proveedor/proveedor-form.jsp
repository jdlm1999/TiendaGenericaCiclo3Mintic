<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">
</link>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand navbar-mr-auto"
				href="<%=request.getContextPath()%>/"><img src="img/logo.png"
				height="30" width="41"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#Navbar"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="Navbar">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link active"
						href="./pages/Usuario/usuarioCrear.jsp"><i class='fas fa-user'></i>
							Usuarios</a></li>
					<li class="nav-item"><a class="nav-link" href="#"><i
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
			</div>
		</div>
	</nav>
	<header></header>

	<div class="jumbotron">
		<div class="container">
			<div class="card">
				<h3 class="card-header bg-dark text-white">Agregar un Cliente</h3>
				<div class="card-body">
					<div class="row row-content">
						<div class="col-12 col-md-9">
							<form action="insert" method="post" id="proveedorForm">
								<div class="form-group row">
									<label for="nombre" class="col-md-2 col-form-label">Nombre:
									</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="nombre"
											name="nombre" placeholder="Nombre" required
											oninvalid="this.setCustomValidity('Ingresar el nombre')"
											oninput="setCustomValidity('')">
									</div>
								</div>
								<div class="form-group row">
									<label for="email" class="col-md-2 col-form-label">Ciudad:
									</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="ciudad"
											name="ciudad" placeholder="Ciudad" required
											oninvalid="this.setCustomValidity('Ingresar la ciudad')"
											oninput="setCustomValidity('')">
									</div>
								</div>
								<div class="form-group row">
									<label for="telefono" class="col-md-2 col-form-label">Telefono</label>
									<div class="col-md-10">
										<input type="tel" class="form-control" id="telefono"
											name="telefono" placeholder="Telefono" required
											oninvalid="this.setCustomValidity('Ingresar el telefono')"
											oninput="setCustomValidity('')">
									</div>
								</div>
								<div class="form-group row">
									<label for="direccion" class="col-md-2 col-form-label">Direccion:
									</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="direccion"
											name="direccion" placeholder="Direccion" required
											oninvalid="this.setCustomValidity('Ingresar la direccion')"
											oninput="setCustomValidity('')">
									</div>
								</div>
								<div class="form-group row">
									<label for="cedula" class="col-md-2 col-form-label">NIT:
									</label>
									<div class="col-md-10">
										<input type="number" class="form-control" id="nit"
											name="nit" placeholder="NIT" required
											oninvalid="this.setCustomValidity('Ingresar el NIT')"
											oninput="setCustomValidity('')">
									</div>
								</div>

								<div role="alert" id="alert">
									<h4 class="alert-heading" id="msg"></h4>
								</div>

								<div class="form-group row">
									<div class="offset-md-2 col-md-10">
										<button type="submit" class="btn btn-success" value="Agregar"
											name="Agregar">Agregar Proveedor</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script src="../js/jquery-3.6.0.min.js"></script>
	<script src="../js/proveedor-form.js"></script>
</body>
</html>