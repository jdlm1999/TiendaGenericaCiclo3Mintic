package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unbosque.ciclo3back.dao.UsuarioDAO;
import co.edu.unbosque.ciclo3back.model.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Controller
public class UsuarioController implements ControllerInterface<Usuario> {

	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	public boolean guardar(Usuario agregar) {
		try {
			Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			String hash = argon2.hash(1, 1024, 1, agregar.getPassword());
			agregar.setPassword(hash);
			usuarioDao.save(agregar);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al agregar al usuario.");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You don't have Authorization");
		}
	}

	@Override
	public Usuario obtenerById(Long id) {
		try {
			return usuarioDao.findById(id).get();
		} catch (Exception e) {
			System.err.println("Error: Al obtener al usuario.");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "You don't have Authorization");
		}
	}
	
	@Override
	public List<Usuario> obtenerTodos() {
		try {
			return usuarioDao.findAll();
		} catch (Exception e) {
			System.err.println("Error: Al obtener los usuarios.");
			return null;
		}
	}

	@Override
	public boolean actualizar(Usuario actualizar) {
		try {
			usuarioDao.save(actualizar);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al actualizar al usuario.");
			return false;
		}
	}

	@Override
	public boolean eliminar(Long id) {
		try {
			usuarioDao.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al eliminar al usuario.");
			return false;
		}
	}
}
