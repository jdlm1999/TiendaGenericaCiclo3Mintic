package co.edu.unbosque.ciclo3back.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.Controller.UsuarioController;
import co.edu.unbosque.ciclo3back.model.Usuario;

@RestController
@RequestMapping("usuarios")
public class UsuarioAPI {

	@Autowired
	private UsuarioController usuarioController;
	
	@PostMapping("/crear")
	public boolean guardar(@RequestBody Usuario usuarios) {
		return usuarioController.guardarUsuario(usuarios);
	}
	
	@GetMapping("/obtener/{id}")
	public Usuario obtener(@PathVariable("id") Long id) {
		return usuarioController.obtenerByCedula(id);
	}

	@GetMapping("/listar")
	public List<Usuario> listar() {
		return usuarioController.obtenerTodos();
	}

	@PutMapping("/actualizar")
	public boolean actualizar(@RequestBody Usuario usuarios) {
		return usuarioController.actualizarUsuario(usuarios);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public boolean eliminar(@PathVariable("id") Long id) {
		return usuarioController.eleminarUsuario(id);
	}
}