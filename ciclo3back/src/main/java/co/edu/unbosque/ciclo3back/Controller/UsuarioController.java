package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ciclo3back.dao.UsuarioDAO;
import co.edu.unbosque.ciclo3back.model.Usuario;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDao;

	public boolean guardarUsuario(Usuario usuario) {
		try {
			Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
			usuario.setPassword(hash);
			usuarioDao.save(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Usuario obtenerByCedula(Long id) {
		try {
			return usuarioDao.findById(id).get();
		} catch (Exception e) {
			System.err.println("Error: No funciono jeje");
			return null;
		}
	}

	public List<Usuario> obtenerTodos() {
		try {
			return usuarioDao.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public boolean actualizarUsuario(Usuario usuario) {
		try {
			usuarioDao.save(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean eleminarUsuario(Long id) {
		try {
			usuarioDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
