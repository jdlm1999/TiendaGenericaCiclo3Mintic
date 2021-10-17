$(document).ready(function() {
	$("#alert").hide();
	$("#userDetail").on('click', function(event) {
		event.preventDefault();
		console.log('Entro');
		var f = $('#userDetail').serialize();
		$.ajax({
			url: "busqueda",
			dataType: "json",
			data: f,
			success: function(data) {
				console.log(data);
				if (data.error === 'No se encuentra') {
					$("#alert").show();
					$("#msg").html("No hemos encontrado el usuario.");
					$("#alert").addClass('alert alert-danger align-items-center');
					var tr = document.getElementById('bodyTable');
					tr.innerHTML = '';
				} else {
					var tr = document.getElementById('bodyTable');
					tr.innerHTML = '';
					tr.innerHTML = `<tr><td>${data.cedula_usuario}</td>
				<td>${data.nombre_usuario}</td>
				<td>${data.email_usuario}</td>
				<td>${data.usuario}</td>
				<td>${data.password}</td>
				</tr>`
					$("#alert").show();
					$("#msg").html("Usuario Encontrado");
					$("#alert").addClass('alert alert-success align-items-center');
				}
			}
		});
		setTimeout(() => {
			$("#alert").hide('fade');
			$("#alert").removeClass();
		}, 2000);
	});
});