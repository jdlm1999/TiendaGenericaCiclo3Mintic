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

import co.edu.unbosque.ciclo3back.Controller.UsuarioController;
import co.edu.unbosque.ciclo3back.model.Usuario;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;

@RestController
@RequestMapping("usuarios")
public class UsuarioAPI implements APIInterface<Usuario> {

	@Autowired
	private UsuarioController usuarioController;

	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/crear")
	public boolean guardar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody Usuario usuarios) {
		return usuarioController.guardar(usuarios);
	}

	@GetMapping("/obtener/{id}")
	public Usuario obtener(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id) {
		try {
			if (!validarToken(token))
				return null;
			return usuarioController.obtenerById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@GetMapping("/listar")
	public List<Usuario> listar(@RequestHeader(value = "Authorization", required = false) String token) {
		try {
			if (!validarToken(token))
				return null;
			return usuarioController.obtenerTodos();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@PutMapping("/actualizar")
	public boolean actualizar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody Usuario actualizar) {
		try {
			if (!validarToken(token))
				return false;
			return usuarioController.actualizar(actualizar);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public boolean eliminar(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id) {
		try {
			if (!validarToken(token))
				return false;
			return usuarioController.eliminar(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	public boolean validarToken(String token) {
		String usuarioId = jwtUtil.getKey(token);
		return usuarioId != null;
	}
}