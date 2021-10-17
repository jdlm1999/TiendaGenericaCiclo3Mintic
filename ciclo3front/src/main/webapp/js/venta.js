/**
 * 
 */
$(document).ready(function() {
	$("#alert").hide();
	console.log('entra');

	$("#buscarCliente").on('click', function(event) {
		event.preventDefault();
		var f = $('#formClient').serialize();

		$.ajax({
			url: "searchClient",
			dataType: "json",
			data: f,
			success: function(data) {
				console.log(data);
				if (data.error === 'No se encuentra') {
					$("#alert").show();
					$("#msg").html("No hemos encontrado el Proveedor.");
					$("#alert").addClass('alert alert-danger align-items-center');
				} else {
					let ced = document.getElementById('inputClienteEncontrado');
					ced.value = data.cedula_cliente;
				}
			}
		});
	});

	$("#buscarProducto1").on('click', function(event) {
		event.preventDefault();
		var f = $('#formProduct1').serialize();

		$.ajax({
			url: "searchProduct3",
			dataType: "json",
			data: f,
			success: function(data) {
				console.log(data);
				if (data.error === 'No se encuentra') {
					$("#alert").show();
					$("#msg").html("No hemos encontrado el Proveedor.");
					$("#alert").addClass('alert alert-danger align-items-center');
				} else {
					let ced = document.getElementById('nomCod1');
					let val = document.getElementById('valor1');
					ced.value = data.nombre_producto;
					val.value = data.precio_venta;
				}
			}
		});
	});

	$("#buscarProducto2").on('click', function(event) {
		event.preventDefault();
		var f = $('#formProduct2').serialize();

		$.ajax({
			url: "searchProduct2",
			dataType: "json",
			data: f,
			success: function(data) {
				console.log(data);
				if (data.error === 'No se encuentra') {
					$("#alert").show();
					$("#msg").html("No hemos encontrado el Proveedor.");
					$("#alert").addClass('alert alert-danger align-items-center');
				} else {
					let ced = document.getElementById('nomCod2');
					let val = document.getElementById('valor2');
					ced.value = data.nombre_producto;
					val.value = data.precio_venta;
				}
			}
		});
	});

	$("#buscarProducto3").on('click', function(event) {
		event.preventDefault();
		var f = $('#formProduct3').serialize();

		$.ajax({
			url: "searchProduct",
			dataType: "json",
			data: f,
			success: function(data) {
				console.log(data);
				if (data.error === 'No se encuentra') {
					$("#alert").show();
					$("#msg").html("No hemos encontrado el Proveedor.");
					$("#alert").addClass('alert alert-danger align-items-center');
				} else {
					let ced = document.getElementById('nomCod3');
					let val = document.getElementById('valor3');
					ced.value = data.nombre_producto;
					val.value = data.precio_venta;
				}
			}
		});
	});

	$("#can1").on("change keyup paste", function() {
		let val = document.getElementById('val1');
		let can = document.getElementById('can1').value;
		let valor = document.getElementById('valor1').value;
		val.value = parseInt(valor) * parseInt(can);
	});

	$("#can2").on("change keyup paste", function() {
		let val = document.getElementById('val2');
		let can = document.getElementById('can2').value;
		let valor = document.getElementById('valor2').value;
		val.value = parseInt(valor) * parseInt(can);
	});

	$("#can3").on("change keyup paste", function() {
		let val = document.getElementById('val3');
		let can = document.getElementById('can3').value;
		let valor = document.getElementById('valor3').value;
		val.value = parseInt(valor) * parseInt(can);
	});

	$("#consultar").on('click', function(event) {
		event.preventDefault();
		let ced = document.getElementById('inputClienteEncontrado').value;
		let cod1 = document.getElementById('nomCod1').value;
		let cod2 = document.getElementById('nomCod2').value;
		let cod3 = document.getElementById('nomCod3').value;
		let can1 = document.getElementById('can1').value;
		let can2 = document.getElementById('can2').value;
		let can3 = document.getElementById('can3').value;
		let val1 = document.getElementById('val1');
		let val2 = document.getElementById('val2');
		let val3 = document.getElementById('val3');

		val1.value = 10;
		val2.value = 20;
		val3.value = 30;

		console.log(ced);
		console.log(cod1);
		console.log(cod2);
		console.log(cod3);
		console.log(can1);
		console.log(can2);
		console.log(can3);
		console.log(val1);
		console.log(val2);
		console.log(val3);
		// console.log(parseInt(cod1) + parseInt(cod2) + parseInt(cod3));
	});
});