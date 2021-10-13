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
<link rel="stylesheet" href="../styles/styles.css">
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
						href="<%=request.getContextPath()%>/UsuarioServlet/list"><i
							class='fas fa-user'></i> Usuarios</a></li>
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
				<h3 class="card-header bg-dark text-white">Agregar un Usuario</h3>
				<div class="card-body">
					<div class="row row-content">
						<div class="col-12 col-sm-8 col-lg-12">
							<form action="insert" method="post" id="userForm">
								<div class="form-group row">
									<label for="usuario" class="col-md-12 col-form-label">Usuario:</label>
									<div class="col-md-12">
										<input type="text" class="form-control" id="usuario"
											placeholder="Usuario" name="usuario" required
											oninvalid="this.setCustomValidity('Ingresar el nombre de usuario')"
											oninput="setCustomValidity('')" />
									</div>
								</div>

								<div class="form-group row">
									<label for="password" class="col-md-12 col-form-label">Password:</label>
									<div class="col-md-12">
										<input type="password" class="form-control" id="password"
											placeholder="Password" name="password" required
											oninvalid="this.setCustomValidity('Ingresar el password')"
											oninput="setCustomValidity('')" />
									</div>
								</div>

								<div class="form-group row">
									<label for="nombre" class="col-md-12 col-form-label">Nombre:</label>
									<div class="col-md-12">
										<input type="text" class="form-control" id="nombre"
											placeholder="Nombre" name="nombre" required
											oninvalid="this.setCustomValidity('Ingresar el Nombre')"
											oninput="setCustomValidity('')" />
									</div>
								</div>

								<div class="form-group row">
									<label for="email" class="col-md-12 col-form-label">Email:</label>
									<div class="col-md-12">
										<input type="email" class="form-control" id="email"
											placeholder="Email" name="email" required
											oninvalid="this.setCustomValidity('Ingresar el Email')"
											oninput="setCustomValidity('')" />
									</div>
								</div>

								<div class="form-group row">
									<label for="cedula" class="col-md-12 col-form-label">Cedula:</label>
									<div class="col-md-12">
										<input type="number" class="form-control" id="cedula"
											placeholder="Cedula" name="cedula" required
											oninvalid="this.setCustomValidity('Ingresar la cedula')"
											oninput="setCustomValidity('')" />
									</div>
								</div>

								<div role="alert" id="alert">
									<h4 class="alert-heading" id="msg"></h4>
								</div>

								<div class="form-group row">
									<div class="offset-md-2 col-md-10">
										<button type="submit" class="btn btn-success" value="Agregar"
											name="Agregar">Agregar Usuario</button>
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
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>

	<script>
		$(document).ready(function() {
			$("#alert").hide();
			$("#userForm").on('submit', function(event) {
				event.preventDefault();
				var f = $('#userForm').serialize();
				console.log(f);

				$.ajax({
					url : "insert",
					data : f,
					type : 'POST',
					success : function(data, textStatus, jqXHR) {
						console.log(data);
						if (data.trim() == 'Usuario Creado') {
							$("#alert").show();
							$("#msg").html("Usuario Creado");
							$("#alert").addClass('alert alert-success align-items-center');
						}
						else if(data.trim() == 'Usuario No Creado'){
							$("#alert").show();
							$("#msg").html("Usuario No Creado");
							$("#alert").addClass('alert alert-danger align-items-center');
						}
						else if(data.trim() == 'Incorrect'){
							$("#alert").show();
							$("#msg").html("Credenciales Incorrectas!!");
							$("#alert").addClass('alert alert-danger align-items-center');
						}
					},
					error : function(jqXHR, testStatus, errorThrown) {
						console.log(data);
						console.log("Error");
					}
				})
				
				setTimeout(() => {
					$("#alert").hide('fade');
					$("#alert").removeClass();
				}, 2000);
			})
		})
	</script>
</body>
</html>