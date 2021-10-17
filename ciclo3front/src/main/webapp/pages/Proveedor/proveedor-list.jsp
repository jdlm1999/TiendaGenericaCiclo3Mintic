<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ page import='co.edu.unbosque.ciclo3.Proveedor.Proveedor'%>
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
					<li class="nav-item"><a class="nav-link active" href=""><i
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
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<div class="row row-content">
				<div class="row row-content">
					<div class="col-12 col-md-9">
						<a href="<%=request.getContextPath()%>/ProveedorServlet/new">
							<button type="button" class="btn btn-success">Agregar
								Proveedor</button>
						</a>
					</div>
				</div>
				<div class="row row-content">
					<div class="col-12 col-md-9">
						<a href="<%=request.getContextPath()%>/ProveedorServlet/detail">
							<button type="button" class="btn btn-info">Busar
								Proveedor</button>
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
									<th>NIT</th>
									<th>Ciudad</th>
									<th>Direccion</th>
									<th>Nombre</th>
									<th>Telefono</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<%
								ArrayList<Proveedor> lista = (ArrayList<Proveedor>) request.getAttribute("lista");
								for (Proveedor proveedor : lista) {
								%>
								<tr>
									<td><%=proveedor.getNit_proveedor()%></td>
									<td><%=proveedor.getCiudad_proveedor()%></td>
									<td><%=proveedor.getDireccion_proveedor()%></td>
									<td><%=proveedor.getNombre_proveedor()%></td>
									<td><%=proveedor.getTelefono_proveedor()%></td>
									<td><button type="button"
											class="btn btn-info btn-circle btn-sm" data-bs-toggle="modal"
											data-bs-target="#actualizarModal"
											onClick="cedulaTableActualizar(this)"
											name="<%=proveedor.getNit_proveedor()%>">
											<i class='fas fa-cloud-upload-alt'></i>
										</button>
										<button type="button" class="btn btn-danger btn-circle btn-sm"
											data-bs-toggle="modal" data-bs-target="#eliminarModal"
											onClick="cedulaTableEliminar(this)"
											name="<%=proveedor.getNit_proveedor()%>">
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
										<input type="number" class="form-control" id=inputCedulaUsuarioActualizar
											name="nit" placeholder="NIT" readonly>
									</div>
								</div>

								<div class="form-group row">
									<div class="offset-md-2 col-md-10">
										<button type="submit" class="btn btn-success" value="Agregar"
											name="Agregar">Actualizar</button>
									</div>
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
					<h5 class="modal-title">Eliminar Proveedor</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form action="delete" method="post"">
					<p>Esta seguro que desea eliminar el Proveedor con NIT:</p>
					<div class="form-group col-sm-4">
						<label class="sr-only" for="inputCedulaUsuario"> NIT del
							Proveedor: </label> <input type="text"
							class="form-control form-control-sm mr-1"
							id="inputCedulaUsuarioEliminar" placeholder="Cédula del Usuario"
							name="nit" readonly>
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
