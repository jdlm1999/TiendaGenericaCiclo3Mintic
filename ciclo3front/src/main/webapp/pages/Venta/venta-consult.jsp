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
</head>
<body>
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
								<button id="buscarCliente" type="submit" class="btn btn-primary"
									value="BuscarCliente">Send Feedback</button>
							</div>
						</div>
						<div class="form-group row">
							<label for="cedula" class="col-md-2 col-form-label">Cliente
								Consultado</label>
							<div class="col-md-4">
								<input type="number" class="form-control"
									id="inputClienteEncontrado" name="cedula" placeholder="Cedula"
									value="" readonly>
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
								<input type="number" class="form-control" id="cod1" name="cod1"
									placeholder="cod1">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-10">
								<button id="buscarProducto1" type="submit"
									class="btn btn-primary" value="BuscarProducto1">Send
									Feedback</button>
							</div>
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
							<label for="can1" class="col-md-2 col-form-label">Cantidad:</label>
							<div class="col-md-4">
								<input type="number" class="form-control" id="can1" name="can1"
									placeholder="can1">
							</div>
						</div>
						<div class="form-group row">
							<label for="val1" class="col-md-2 col-form-label">Valor
								Total:</label>
							<div class="col-md-4">
								<input type="number" class="form-control" id="val1" name="val1"
									placeholder="val1" readonly>
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
								<input type="number" class="form-control" id="cod2" name="cod2"
									placeholder="cod2">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-10">
								<button id="buscarProducto2" type="submit"
									class="btn btn-primary" value="BuscarProducto2">Send
									Feedback</button>
							</div>
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
							<label for="can2" class="col-md-2 col-form-label">Cantidad:</label>
							<div class="col-md-4">
								<input type="number" class="form-control" id="can2" name="can2"
									placeholder="can2">
							</div>
						</div>
						<div class="form-group row">
							<label for="val2" class="col-md-2 col-form-label">Valor
								Total:</label>
							<div class="col-md-4">
								<input type="number" class="form-control" id="val2" name="val2"
									placeholder="val2" readonly>
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
								<input type="number" class="form-control" id="cod3" name="cod3"
									placeholder="cod3">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-10">
								<button id="buscarProducto3" type="submit"
									class="btn btn-primary" value="BuscarProducto3">Send
									Feedback</button>
							</div>
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
							<label for="can3" class="col-md-2 col-form-label">Cantidad:</label>
							<div class="col-md-4">
								<input type="number" class="form-control" id="can3" name="can3"
									placeholder="can3">
							</div>
						</div>
						<div class="form-group row">
							<label for="val3" class="col-md-2 col-form-label">Valor
								Total:</label>
							<div class="col-md-4">
								<input type="number" class="form-control" id="val3" name="val3"
									placeholder="val3" readonly>
							</div>
						</div>


					</form>
				</div>
			</div>
		</div>
	</div>



	<button id="consultar" type="submit" class="btn btn-primary">
		Send Feedback</button>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script src="../js/jquery-3.6.0.min.js"></script>
	<script src="../js/venta.js"></script>
</body>
</html>