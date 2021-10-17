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

import co.edu.unbosque.ciclo3back.Controller.ClienteController;
import co.edu.unbosque.ciclo3back.model.Cliente;
import co.edu.unbosque.ciclo3back.model.Usuario;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;
import io.jsonwebtoken.SignatureException;

@RestController
@RequestMapping("clientes")
public class ClienteAPI implements APIInterface<Cliente> {

	@Autowired
	private ClienteController clienteController;

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	@PostMapping("/crear")
	public boolean guardar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody Cliente agregar, HttpServletResponse response) {

		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return false;
			}
			System.err.println("Entra api cliente");
			String rta = clienteController.guardar(agregar, token);

			if (rta.equals("Ya existe un cliente con el id"))
				response.setStatus(HttpServletResponse.SC_FOUND);
			if (rta.equals("Credenciales invalidas"))
				response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			if (rta.equals("Credenciales Vacias"))
				response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
			if (rta.equals("Cliente Agregado")) {
				response.setStatus(HttpServletResponse.SC_OK);
				return true;
			}
			return false;
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return false;
		}
	}

	@Override
	@GetMapping("/obtener/{id}")
	public Cliente obtener(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id, HttpServletResponse response) {
		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return null;
			}
			Cliente ret = clienteController.obtenerById(id, token);
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

	@Override
	@GetMapping("/listar")
	public List<Cliente> listar(@RequestHeader(value = "Authorization", required = false) String token,
			HttpServletResponse response) {
		try {
			if (token == null || token.equals(""))
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			ArrayList<Cliente> ret = (ArrayList<Cliente>) clienteController.obtenerTodos(token);
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

	@Override
	@PutMapping("/actualizar")
	public boolean actualizar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody Cliente actualizar, HttpServletResponse response) {
		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return false;
			}
			String rta = clienteController.actualizar(actualizar, token);
			if (rta.equals("No existe el Cliente"))
				response.setStatus(HttpServletResponse.SC_FOUND);
			if (rta.equals("Credenciales Vacias"))
				response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
			if (rta.equals("Credenciales invalidas"))
				response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			if (rta.equals("Cliente Actualizado")) {
				response.setStatus(HttpServletResponse.SC_OK);
				return true;
			}
			return false;
		} catch (SignatureException e) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return false;
		}
	}

	@Override
	@DeleteMapping("/eliminar/{id}")
	public boolean eliminar(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id, HttpServletResponse response) {
		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return false;
			}
			String rta = clienteController.eliminar(id, token);
			if (rta.equals("No existe el cliente"))
				response.setStatus(HttpServletResponse.SC_FOUND);
			if (rta.equals("Cliente Eliminado")) {
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