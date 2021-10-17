/**
 * 
 */
$(document).ready(function() {
	$("#alertCliente").hide();
	$("#alertP1").hide();
	$("#alertP2").hide();
	$("#alertP3").hide();
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
					$("#alertCliente").show();
					$("#msgCliente").html("No hemos encontrado el Cliente.");
					$("#alertCliente").addClass('alert alert-danger align-items-center');
				} else {
					let ced = document.getElementById('inputClienteEncontrado');
					let ced2 = document.getElementById('inputClienteEncontrado2');
					ced.value = data.nombre_cliente;
					ced2.value = data.cedula_cliente;
					$("#alertCliente").show();
					$("#msgCliente").html("Se ha encontrado el cliente.");
					$("#alertCliente").addClass('alert alert-success align-items-center');
				}
				setTimeout(() => {
					$("#alertCliente").hide('fade');
					$("#alertCliente").removeClass();
				}, 2000);
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
					$("#alertP1").show();
					$("#msgP1").html("No hemos encontrado el Producto.");
					$("#alertP1").addClass('alert alert-danger align-items-center');
				} else {
					let ced = document.getElementById('nomCod1');
					let val = document.getElementById('valor1');
					ced.value = data.nombre_producto;
					val.value = data.precio_venta;
					$("#alertP1").show();
					$("#msgP1").html("Se ha encontrado el Producto.");
					$("#alertP1").addClass('alert alert-success align-items-center');
				}
				setTimeout(() => {
					$("#alertP1").hide('fade');
					$("#alertP1").removeClass();
				}, 2000);
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
					$("#alertP2").show();
					$("#msgP2").html("No hemos encontrado el Producto.");
					$("#alertP2").addClass('alert alert-danger align-items-center');
				} else {
					let ced = document.getElementById('nomCod2');
					let val = document.getElementById('valor2');
					ced.value = data.nombre_producto;
					val.value = data.precio_venta;
					$("#alertP2").show();
					$("#msgP2").html("Se ha encontrado el Producto.");
					$("#alertP2").addClass('alert alert-success align-items-center');
				}
				setTimeout(() => {
					$("#alertP2").hide('fade');
					$("#alertP2").removeClass();
				}, 2000);
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
					$("#alertP3").show();
					$("#msgP3").html("No hemos encontrado el Producto.");
					$("#alertP3").addClass('alert alert-danger align-items-center');
				} else {
					let ced = document.getElementById('nomCod3');
					let val = document.getElementById('valor3');
					ced.value = data.nombre_producto;
					val.value = data.precio_venta;
					$("#alertP3").show();
					$("#msgP3").html("Se ha encontrado el Producto.");
					$("#alertP3").addClass('alert alert-success align-items-center');
				}
				setTimeout(() => {
					$("#alertP3").hide('fade');
					$("#alertP3").removeClass();
				}, 2000);
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