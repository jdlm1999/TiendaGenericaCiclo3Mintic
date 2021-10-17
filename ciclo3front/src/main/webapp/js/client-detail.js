$(document).ready(function() {
	$("#alert").hide();
	$("#clientDetail").on('click', function(event) {
		event.preventDefault();
		console.log('Entro');
		var f = $('#clientDetail').serialize();
		$.ajax({
			url: "busqueda",
			dataType: "json",
			data: f,
			success: function(data) {
				console.log(data.nombre_cliente);
				if (data.error === 'No se encuentra') {
					$("#alert").show();
					$("#msg").html("No hemos encontrado el Cliente.");
					$("#alert").addClass('alert alert-danger align-items-center');
					var tr = document.getElementById('bodyTable');
					tr.innerHTML = '';
				} else {
					var tr = document.getElementById('bodyTable');
					tr.innerHTML = '';
					tr.innerHTML = `<tr><td>${data.cedula_cliente}</td>
				<td>${data.nombre_cliente}</td>
				<td>${data.email_cliente}</td>
				<td>${data.telefono_cliente}</td>
				<td>${data.direccion_cliente}</td>
				</tr>`
					$("#alert").show();
					$("#msg").html("Cliente Encontrado");
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