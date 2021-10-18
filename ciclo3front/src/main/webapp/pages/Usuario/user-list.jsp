<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ page import='co.edu.unbosque.ciclo3.Usuario.Usuario'%>
<%@ page import='java.util.ArrayList'%>
<!DOCTYPE html>
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
					<li class="nav-item"><a class="nav-link active" href="#"><i
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
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/ReporteServlet/reportes"><i
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
				<div class="row row-content">
					<div class="col-12 col-md-9">
						<a href="<%=request.getContextPath()%>/UsuarioServlet/new">
							<button type="button" class="btn btn-success">Agregar
								Usuario</button>
						</a>
					</div>
				</div>
				<div class="row row-content">
					<div class="col-12 col-md-9">
						<a href="<%=request.getContextPath()%>/UsuarioServlet/detail">
							<button type="button" class="btn btn-info">Busar Usuario</button>
						</a>
					</div>
				</div>
			</div>
			<div class="row row-content">
				<div class="col-12 col-md-9">
					<h2>Usuarios Registrados</h2>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead class="thead-dark">

								<tr>
									<th>Cedula</th>
									<th>Nombre</th>
									<th>Correo</th>
									<th>Usuario</th>
									<th>Password</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<%
								ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("lista");
								for (Usuario usuario : lista) {
								%>
								<tr>
									<td><%=usuario.getCedula_usuario()%></td>
									<td><%=usuario.getNombre_usuario()%></td>
									<td><%=usuario.getEmail_usuario()%></td>
									<td><%=usuario.getUsuario()%></td>
									<td>**********</td>
									<td><button type="button"
											class="btn btn-info btn-circle btn-sm" data-bs-toggle="modal"
											data-bs-target="#actualizarModal"
											onClick="cedulaTableActualizar(this)"
											name="<%=usuario.getCedula_usuario()%>">
											<i class='fas fa-cloud-upload-alt'></i>
										</button>
										<button type="button" class="btn btn-danger btn-circle btn-sm"
											data-bs-toggle="modal" data-bs-target="#eliminarModal"
											onClick="cedulaTableEliminar(this)"
											name="<%=usuario.getCedula_usuario()%>">
											<i class='fas fa-trash'></i>
										</button></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
				<div class="col-12 col-sm-3"></div>
			</div>
		</div>
	</div>

	<div id="actualizarModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg" role="content">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Login</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="update" method="post">
						<div class="form-group row">
							<label for="usuario" class="col-md-2 col-form-label">Usuario:
							</label>
							<div class="col-md-10">
								<input type="text" class="form-control" id="usuario"
									name="usuario" placeholder="Usuario">
							</div>
						</div>
						<div class="form-group row">
							<label for="password" class="col-md-2 col-form-label">Password:
							</label>
							<div class="col-md-10">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="Password">
							</div>
						</div>
						<div class="form-group row">
							<label for="nombre" class="col-md-2 col-form-label">Nombre
								del Usuario: </label>
							<div class="col-md-10">
								<input type="text" class="form-control" id="nombre"
									name="nombre" placeholder="Nombre">
							</div>
						</div>
						<div class="form-group row">
							<label for="email" class="col-md-2 col-form-label">Email:
							</label>
							<div class="col-md-10">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="Email">
							</div>
						</div>
						<div class="form-group row">
							<label for="cedula" class="col-md-2 col-form-label">Cedula:
							</label>
							<div class="col-md-10">
								<input type="text" class="form-control"
									id="inputCedulaUsuarioActualizar" name="cedula"
									placeholder="Cedula" readonly>
							</div>
						</div>
						<div class="form-row">
							<button type="button" class="btn btn-secondary btn-sm ml-auto"
								id="cancelloginbutton">Cancel</button>
							<input class="btn btn-danger" type="submit" value="Actualizar"
								name="Actualizar">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div id="eliminarModal" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Eliminar Usuario</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form action="delete" method="post"">
					<p>Esta seguro que desea eliminar el usuario con cédula:</p>
					<div class="form-group col-sm-4">
						<label class="sr-only" for="inputCedulaUsuario"> Cédula
							del Usuario: </label> <input type="text"
							class="form-control form-control-sm mr-1"
							id="inputCedulaUsuarioEliminar" placeholder="Cédula del Usuario"
							name="cedula" readonly>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<input class="btn btn-danger" type="submit" value="Eliminar"
							name="Eliminar">
					</div>
				</form>
			</div>
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

	<script type="text/javascript">
		function cedulaTableActualizar(e) {
			let cedula = e.name;
			let modalCedula = document
					.getElementById('inputCedulaUsuarioActualizar');
			modalCedula.value = cedula;
		}
		function cedulaTableEliminar(e) {
			let cedula = e.name;
			let modalCedula = document
					.getElementById('inputCedulaUsuarioEliminar');
			modalCedula.value = cedula;
		}
	</script>
</body>

</html>
