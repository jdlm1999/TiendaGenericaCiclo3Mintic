<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="busqueda" method="post" id="userForm">
		<input type="number" class="form-control" id="busqueda"
			placeholder="Ingresar la cedula" name="busqueda" required
			oninvalid="this.setCustomValidity('Ingresar una cedula valida')"
			oninput="setCustomValidity('')" />
		<div class="form-group row">
			<div class="offset-md-2 col-md-10">
				<button type="submit" class="btn btn-success" value="Buscar"
					name="Buscar">Agregar Usuario</button>
			</div>
		</div>
	</form>
</body>
</html>