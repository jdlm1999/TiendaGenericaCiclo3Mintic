<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post" enctype="multipart/form-data">
		<div>
			<label>Archivo con los productos:</label><input type="file" value="Examinar"
				name="archivo">
		</div>
		<div class="form-group row">
			<div class="offset-md-2 col-md-10">
				<button type="submit" class="btn btn-success" value="Subir Archivo"
					name="cargar">Subir Archivo</button>
			</div>
		</div>
	</form>
</body>
</html>