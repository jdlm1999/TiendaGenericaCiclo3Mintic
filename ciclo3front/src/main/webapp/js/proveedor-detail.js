$(document).ready(function() {
	$("#alert").hide();
	$("#proveedorDetail").on('click', function(event) {
		event.preventDefault();
		console.log('Entro');
		var f = $('#proveedorDetail').serialize();
		$.ajax({
			url: "busqueda",
			dataType: "json",
			data: f,
			success: function(data) {
				console.log(data);
				if (data.error === 'No se encuentra') {
					$("#alert").show();
					$("#msg").html("No hemos encontrado el Proveedor.");
					$("#alert").addClass('alert alert-danger align-items-center');
					var tr = document.getElementById('bodyTable');
					tr.innerHTML = '';
				} else {
					var tr = document.getElementById('bodyTable');
					tr.innerHTML = '';
					tr.innerHTML = `<tr><td>${data.nit_proveedor}</td>
				<td>${data.nombre_proveedor}</td>
				<td>${data.ciudad_proveedor}</td>
				<td>${data.direccion_proveedor}</td>
				<td>${data.telefono_proveedor}</td>
				</tr>`
					$("#alert").show();
					$("#msg").html("Proveedor Encontrado");
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