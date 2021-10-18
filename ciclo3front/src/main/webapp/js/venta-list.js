/**
 * 
 */
$(document).ready(function() {
	let total = 0;
	console.log('entra');
	$("#ventalist").on('click', function(event) {
		event.preventDefault();
		console.log('Entro');
		var f = $('#ventalist').serialize();
		$.ajax({
			url: "list",
			dataType: "json",
			data: f,
			success: function(data) {
				console.log(data);
				if (data.error === 'No se encuentra') {
					$("#alert").show();
					$("#msg").html("No hemos ventas");
					$("#alert").addClass('alert alert-danger align-items-center');
					var tr = document.getElementById('table-venta');
					tr.innerHTML = '';
				} else {
					var tr = document.getElementById('table-venta');
					tr.innerHTML = '';
					for (let i of data) {
						tr.innerHTML += `<tr>
			<td>${i.codigo_venta}</td>
			<td>${i.cedula_cliente}</td>
			<td>${i.cedula_usuario}</td>
			<td>${i.iva_venta}</td>
			<td>${i.valor_venta}</td>
			<td>${i.total_venta}</td>
			</tr>`
			total += parseInt(i.total_venta);
					}
					var tot = document.getElementById('totalventas');
					console.log(total);
					tot.value = total;
					$("#alert").show();
					$("#msg").html("Ventas Encontradas");
					$("#alert").addClass('alert alert-success align-items-center');
				}
			}
		});
		setTimeout(() => {
			$("#alert").hide('fade');
			$("#alert").removeClass();
		}, 2000);
	}
	);
});