/**
 * 
 */
$(document).ready(function() {
	console.log('entra');
	$("#productolist").on('click', function(event) {
		event.preventDefault();
		console.log('Entro');
		var f = $('#productolist').serialize();
		$.ajax({
			url: "list",
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
					var tr = document.getElementById('cards-products');
					tr.innerHTML = '';
					for (let i of data) {
						tr.innerHTML += `<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://upload.wikimedia.org/wikipedia/commons/6/6d/Good_Food_Display_-_NCI_Visuals_Online.jpg" alt="Card image cap">
  <div class="card-body">
    <h3 class="card-title">${i.nombre_producto}</h3>
<h5 class="card-text">Codigo del producto: ${i.codigo_producto}</h5>
<h5 class="card-text">Precio de Venta: $${i.precio_venta}</h5>
<h5 class="card-text">Iva del Producto: ${i.iva_compra}</h5>

  </div>
</div>`
					}
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
	}
	);
});