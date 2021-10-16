package co.edu.unbosque.ciclo3back.api;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import co.edu.unbosque.ciclo3back.model.Producto;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;

@RestController
@RequestMapping("productos")
public class ProductosAPI implements APIInterface<Producto>{
	
	@Autowired
	private ProductoController productoController;
	
	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/crear")
	public void guardar(@RequestBody MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("Prueba.csv")));
				stream.write(bytes);
				stream.close();
				System.out.println("You successfully uploaded!");
				productoController.cargarLibros();
			} catch (Exception e) {
				System.err.println("You failed to upload => " + e.getMessage());
			}
		} else {
			System.err.println("You failed to upload because the file was empty.");
		}
	}

	@Override
	public boolean guardar(String token, Producto agregar, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto obtener(@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable("id") Long id, HttpServletResponse response) {
		try {
			if (!validarToken(token))
				return null;
			return productoController.obtenerById(id, token);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@Override
	public List<Producto> listar(String token, HttpServletResponse response) {
		try {
			if (!validarToken(token))
				return null;
			return productoController.obtenerTodos(token);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@Override
	public boolean actualizar(String token, Producto actualizar, HttpServletResponse response) {
		try {
			if (!validarToken(token))
				return false;
			return true;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@Override
	public boolean eliminar(String token, Long id, HttpServletResponse response) {
		try {
			if (!validarToken(token))
				return false;
			return true;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}
	
	public boolean validarToken(String token) {
		String usuarioId = jwtUtil.getKey(token);
		return usuarioId != null;
	}
}
