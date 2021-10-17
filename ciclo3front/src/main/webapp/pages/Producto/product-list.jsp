<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import='co.edu.unbosque.ciclo3.Usuario.Usuario'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
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
	<form action="busqueda" method="post" id="productolist">
		<div class="form-group row">
			<div class="col-md-12">
				<button type="submit" class="btn btn-success" value="Buscar"
					name="Buscar">Buscar Usuario</button>
			</div>
		</div>

	</form>

	<div role="alert" id="alert">
		<h4 class="alert-heading" id="msg"></h4>
	</div>
	<section class="cards-product" id="cards-products"></section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script src="../js/jquery-3.6.0.min.js"></script>
	<script src="../js/product-list.js"></script>
</body>
</html>