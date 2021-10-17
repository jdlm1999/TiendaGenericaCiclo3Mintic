package co.edu.unbosque.ciclo3back.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import io.jsonwebtoken.SignatureException;

@RestController
@RequestMapping("usuarios")
public class UsuarioAPI implements APIInterface<Usuario> {

	@Autowired
	private UsuarioController usuarioController;

	@PostMapping("/crear")
	public boolean guardar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody Usuario usuarios, HttpServletResponse response) throws ResponseStatusException {
		String rta = usuarioController.guardar(usuarios);
		
		System.out.println(rta);

		if (rta.equals("Ya existe un usuario con el id"))
			response.setStatus(HttpServletResponse.SC_FOUND);
		if (rta.equals("Credenciales invalidas"))
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		if (rta.equals("Credenciales Vacias"))
			response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
		if (rta.equals("Usuario Agregado")) {
			response.setStatus(HttpServletResponse.SC_OK);
			return true;
		}
		return false;
	}

	@GetMapping("/obtener/{id}")
	public Usuario obtener(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id, HttpServletResponse response) {
		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return null;
			}
			Usuario ret = usuarioController.obtenerById(id, token);
			if (ret == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return ret;
			} else {
				response.setStatus(HttpServletResponse.SC_OK);
				return ret;
			}
		} catch (SignatureException e) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return null;
		}
	}

	@GetMapping("/listar")
	public List<Usuario> listar(@RequestHeader(value = "Authorization", required = false) String token,
			HttpServletResponse response) throws ResponseStatusException {
		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return null;
			}
			ArrayList<Usuario> ret = (ArrayList<Usuario>) usuarioController.obtenerTodos(token);
			if (ret == null)
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			else {
				response.setStatus(HttpServletResponse.SC_OK);
				return ret;
			}
			return ret;
		} catch (SignatureException e) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return null;
		}
	}

	@PutMapping("/actualizar")
	public boolean actualizar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody Usuario actualizar, HttpServletResponse response) throws ResponseStatusException {
		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return false;
			}
			String rta = usuarioController.actualizar(actualizar, token);
			if (rta.equals("No existe el usuario"))
				response.setStatus(HttpServletResponse.SC_FOUND);
			if (rta.equals("Credenciales Vacias"))
				response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
			if (rta.equals("Credenciales invalidas"))
				response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			if (rta.equals("Usuario Actualizado")) {
				response.setStatus(HttpServletResponse.SC_OK);
				return true;
			}
			return false;
		} catch (SignatureException e) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return false;
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public boolean eliminar(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id, HttpServletResponse response) throws ResponseStatusException {
		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return false;
			}
			String rta = usuarioController.eliminar(id, token);
			if (rta.equals("No existe el usuario"))
				response.setStatus(HttpServletResponse.SC_FOUND);
			if (rta.equals("Usuario Eliminado")) {
				response.setStatus(HttpServletResponse.SC_OK);
				return true;
			}
			return false;
		} catch (SignatureException e) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return false;
		}

	}

}