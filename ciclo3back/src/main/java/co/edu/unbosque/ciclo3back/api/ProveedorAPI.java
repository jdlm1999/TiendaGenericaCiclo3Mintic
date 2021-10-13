package co.edu.unbosque.ciclo3back.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unbosque.ciclo3back.Controller.ProveedorController;
import co.edu.unbosque.ciclo3back.model.Proveedor;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;

@RestController
@RequestMapping("proveedores")
public class ProveedorAPI implements APIInterface<Proveedor> {

	@Autowired
	private ProveedorController proveedorController;
	@Autowired
	private JWTUtil jwtUtil;

	@Override
	@PostMapping("/crear")
	public boolean guardar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody Proveedor agregar) {
		try {
			if (!validarToken(token))
				return false;
			return proveedorController.guardar(agregar);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@Override
	@GetMapping("/obtener/{id}")
	public Proveedor obtener(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id) {
		try {
			if (!validarToken(token))
				return null;
			return proveedorController.obtenerById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@Override
	@GetMapping("/listar")
	public List<Proveedor> listar(@RequestHeader(value = "Authorization", required = false) String token) {
		try {
			if (!validarToken(token))
				return null;
			return proveedorController.obtenerTodos();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@Override
	@PutMapping("/actualizar")
	public boolean actualizar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody Proveedor actualizar) {
		try {
			if (!validarToken(token))
				return false;
			return proveedorController.actualizar(actualizar);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@Override
	@DeleteMapping("/eliminar/{id}")
	public boolean eliminar(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id) {
		try {
			if (!validarToken(token))
				return false;
			return proveedorController.eliminar(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	public boolean validarToken(String token) {
		String usuarioId = jwtUtil.getKey(token);
		return usuarioId != null;
	}

}