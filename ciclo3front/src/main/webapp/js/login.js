/**
 * 
 */
$(document).ready(function() {
	
	$("#para").scroll(function() {
		$('.toast').toast('show');
	});
	
	$("#alert").hide();
	$("#loginForm").on('submit', function(event) {
		event.preventDefault();
		var f = $('#loginForm').serialize();
		console.log(f);

		$.ajax({
			url: "init",
			data: f,
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				console.log(data);
				if (data.trim() == 'success') {
					$("#alert").show();
					$("#msg").html("Bienvenido a la tienda!!!");
					$("#alert").addClass('alert alert-success align-items-center');
				}
				else if (data.trim() == 'No Exist') {
					$("#alert").show();
					$("#msg").html("No hemos encontrado el usuario.");
					$("#alert").addClass('alert alert-danger align-items-center');
				}
				else if (data.trim() == 'Incorrect') {
					$("#alert").show();
					$("#msg").html("Credenciales Incorrectas!!");
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