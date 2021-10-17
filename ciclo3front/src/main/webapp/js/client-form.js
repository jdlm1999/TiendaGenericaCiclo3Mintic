/**
 * Scripts de usuario-form.jsp
 */
$(document).ready(function() {
	$("#alert").hide();
	$("#clientForm").on('submit', function(event) {
		event.preventDefault();
		var f = $('#clientForm').serialize();
		console.log(f);

		$.ajax({
			url: "insert",
			data: f,
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				console.log(data);
				if (data.trim() == 'Creado') {
					$("#alert").show();
					$("#msg").html("El cliente ha sido registrado con exito!!!");
					$("#alert").addClass('alert alert-success align-items-center');
					setTimeout(() => {
						window.location.href = "../";
					}, 2000);
				}
				else if (data.trim() == 'Existe ID') {
					$("#alert").show();
					$("#msg").html("Ya existe un cliente con la misma cedula.");
					$("#alert").addClass('alert alert-danger align-items-center');
				}
				else if (data.trim() == 'Existe Credenciales') {
					$("#alert").show();
					$("#msg").html("Ya existe un cliente con el mismo correo.");
					$("#alert").addClass('alert alert-danger align-items-center');
				}
			},
			error: function(jqXHR, testStatus, errorThrown) {
				console.log(data);
				console.log("Error");
			}
		})

		setTimeout(() => {
			$("#alert").hide('fade');
			$("#alert").removeClass();
		}, 2000);
	})
});