package co.edu.unbosque.ciclo3back.api;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unbosque.ciclo3back.Controller.ProductoController;
import co.edu.unbosque.ciclo3back.model.Cliente;
import co.edu.unbosque.ciclo3back.model.Producto;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;
import io.jsonwebtoken.SignatureException;

@RestController
@RequestMapping("productos")
public class ProductosAPI implements APIInterface<Producto> {

	@Autowired
	private ProductoController productoController;

	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/crear")
	public boolean guardar(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody MultipartFile file, HttpServletResponse response) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("Prueba.csv")));
				stream.write(bytes);
				stream.close();
				System.out.println("You successfully uploaded!");
				productoController.cargarLibros(token);
				return true;
			} catch (Exception e) {
				System.err.println("You failed to upload => " + e.getMessage());
				response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
				return false;
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return false;
		}
	}

	@Override
	@GetMapping("/obtener/{id}")
	public Producto obtener(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id, HttpServletResponse response) {
		try {
			if (token == null || token.equals("")) {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return null;
			}
			Producto ret = productoController.obtenerById(id, token);
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
	public List<Producto> listar(@RequestHeader(value = "Authorization", required = false) String token,
			HttpServletResponse response) {
		try {
			if (token == null || token.equals(""))
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			ArrayList<Producto> ret = (ArrayList<Producto>) productoController.obtenerTodos(token);
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
			@RequestBody Producto actualizar, HttpServletResponse response) {
		try {
			if (!validarToken(token))
				return false;
			return true;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
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
			String rta = productoController.eliminar(id, token);
			if (rta.equals("No existe el producto"))
				response.setStatus(HttpServletResponse.SC_FOUND);
			if (rta.equals("Producto Eliminado")) {
				response.setStatus(HttpServletResponse.SC_OK);
				return true;
			}
			return false;
		} catch (SignatureException e) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return false;
		}
	}

	public boolean validarToken(String token) {
		String usuarioId = jwtUtil.getKey(token);
		return usuarioId != null;
	}

	@Override
	public boolean guardar(String token, Producto agregar, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}
}
