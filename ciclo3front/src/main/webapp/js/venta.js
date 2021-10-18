/**
 * 
 */
$(document).ready(function() {
	let total1 = 0;
	let total2 = 0;
	let total3 = 0;
	let iva1 = 0;
	let iva2 = 0;
	let iva3 = 0;
	$("#alertCliente").hide();
	$("#alertP1").hide();
	$("#alertP2").hide();
	$("#alertP3").hide();
	$("#alertVenta").hide();
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
		total1 = parseInt(valor) * parseInt(can);
		iva1 = total1 * 0.19;
		val.value = total1;
		total();
	});

	$("#can2").on("change keyup paste", function() {
		let val = document.getElementById('val2');
		let can = document.getElementById('can2').value;
		let valor = document.getElementById('valor2').value;
		total2 = parseInt(valor) * parseInt(can);
		iva2 = total2 * 0.19;
		val.value = total2;
		total();
	});

	$("#can3").on("change keyup paste", function() {
		let val = document.getElementById('val3');
		let can = document.getElementById('can3').value;
		let valor = document.getElementById('valor3').value;
		total3 = parseInt(valor) * parseInt(can);
		iva3 = total3 * 0.19;
		val.value = total3;
		total();
	});

	$("#buscarCliente").on("click", function() {
		console.log('change');
		setTimeout(() => {
			let val = document.getElementById('cedulaClienteVenta');
			let can = document.getElementById('inputClienteEncontrado2').value;
			console.log(can);
			val.value = can;
		}, 2000);
	});

	function total() {
		let val = document.getElementById('valorVenta');
		let val1 = document.getElementById('totalVenta');
		let val3 = document.getElementById('ivaVenta');
		val3.value = Math.round(iva1 + iva2 + iva3);
		val.value = total1 + total2 + total3;
		val1.value = Math.round((total1 + total2 + total3) + (iva1 + iva2 + iva3));
	}

	$("#postVenta").on('submit', function(event) {
		event.preventDefault();
		var f = $('#postVenta').serialize();

		console.log("Venta")

		$.ajax({
			url: "createVenta",
			data: f,
			type: 'POST',
			success: function(data) {
				console.log(data);
				if (data.trim() === 'Existe ID') {
					$("#alertVenta").show();
					$("#msgVenta").html("No se ha creado la venta");
					$("#alertVenta").addClass('alert alert-danger align-items-center');
				}
				else if (data.trim() === 'Existe Credenciales') {
					$("#alertVenta").show();
					$("#msgVenta").html("Ya existe una venta con el cliente");
					$("#alertVenta").addClass('alert alert-danger align-items-center');
				}
				else {

					$("#alertVenta").show();
					$("#msgVenta").html("Se ha creado la venta exitosamente!!!");
					$("#alertVenta").addClass('alert alert-success align-items-center');
				}
				setTimeout(() => {
					$("#alertVenta").hide('fade');
					$("#alertVenta").removeClass();
				}, 2000);
			}
		});
	});
});