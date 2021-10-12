package co.edu.unbosque.ciclo3back.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.Controller.UsuarioController;
import co.edu.unbosque.ciclo3back.model.Usuario;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;

@RestController
@RequestMapping("usuarios")
public class UsuarioAPI {

	@Autowired
	private UsuarioController usuarioController;
	
	@Autowired
    private JWTUtil jwtUtil;

	@PostMapping("/crear")
	public void guardar(@RequestBody Usuario usuarios) {
		usuarioController.guardarUsuario(usuarios);
	}

	@GetMapping("/obtener/{id}")
	public Usuario obtener(@RequestHeader(value = "Authorization") String token, @PathVariable("id") Long id) {
		return usuarioController.obtenerByCedula(id);
	}

	@GetMapping("/listar")
	public List<Usuario> listar(@RequestHeader(value = "Authorization") String token) {
		if (!validarToken(token)) 
			return null;
		return usuarioController.obtenerTodos();
	}

	@PutMapping("/actualizar")
	public boolean actualizar(@RequestHeader(value = "Authorization") String token, @RequestBody Usuario usuarios) {
		if (!validarToken(token))
			return false;
		return usuarioController.actualizarUsuario(usuarios);
	}

	@DeleteMapping("/eliminar/{id}")
	public boolean eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable("id") Long id) {
		if (!validarToken(token))
			return false;
		return usuarioController.eleminarUsuario(id);
	}
	
	private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}