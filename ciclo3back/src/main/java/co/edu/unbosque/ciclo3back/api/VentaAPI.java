package co.edu.unbosque.ciclo3back.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.Controller.VentaController;
import co.edu.unbosque.ciclo3back.model.Cliente;
import co.edu.unbosque.ciclo3back.model.Venta;
import io.jsonwebtoken.SignatureException;


@RestController
@RequestMapping("ventas")
public class VentaAPI implements APIInterface<Venta>{
	
	@Autowired
	private VentaController ventaController;

	@Override
	@PostMapping("/crear")
	public boolean guardar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody Venta agregar, HttpServletResponse response) {
		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return false;
			}
			System.err.println("Entra api Venta");
			String rta = ventaController.guardar(agregar, token);

			if (rta.equals("Ya existe una venta con el id"))
				response.setStatus(HttpServletResponse.SC_FOUND);
			if (rta.equals("Credenciales invalidas"))
				response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			if (rta.equals("Credenciales Vacias"))
				response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
			if (rta.equals("Venta Agregado")) {
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
	public Venta obtener(String token, Long id, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/listar")
	public List<Venta> listar(@RequestHeader(value = "Authorization", required = false) String token,
			HttpServletResponse response) {
		try {
			if (token == null || token.equals(""))
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			ArrayList<Venta> ret = (ArrayList<Venta>) ventaController.obtenerTodos(token);
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
	public boolean actualizar(String token, Venta actualizar, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(String token, Long id, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
