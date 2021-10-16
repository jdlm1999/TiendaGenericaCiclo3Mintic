package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.edu.unbosque.ciclo3back.dao.UsuarioDAO;
import co.edu.unbosque.ciclo3back.model.Usuario;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import io.jsonwebtoken.SignatureException;

@Controller
public class UsuarioController implements ControllerInterface<Usuario> {

	@Autowired
	private UsuarioDAO usuarioDao;

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public String guardar(Usuario agregar) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash = argon2.hash(1, 1024, 1, agregar.getPassword());
		agregar.setPassword(hash);

		try {
			if (usuarioDao.existsById(agregar.getCedula_usuario()))
				return "Ya existe un usuario con el id";
			if (!agregar.getUsuario().equals("") && !agregar.getPassword().equals("")) {
				usuarioDao.save(agregar);
				return "Usuario Agregado";
			} else
				return "Credenciales Vacias";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Credenciales invalidas";
		}
	}

	@Override
	public Usuario obtenerById(Long id, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			return usuarioDao.findById(id).get();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Usuario> obtenerTodos(String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			return usuarioDao.findAll();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public String actualizar(Usuario actualizar, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			if (!usuarioDao.existsById(actualizar.getCedula_usuario()))
				return "No existe el usuario";
			if (!actualizar.getUsuario().equals("") && !actualizar.getPassword().equals("")) {
				usuarioDao.save(actualizar);
				return "Usuario Actualizado";
			} else
				return "Credenciales Vacias";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Credenciales invalidas";
		}
	}

	@Override
	public String eliminar(Long id, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			if (!usuarioDao.existsById(id))
				return "No existe el usuario";
			usuarioDao.deleteById(id);
			return "Usuario Eliminado";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Exception";
		}
	}

	public boolean validarToken(String token) {
		String usuarioId = jwtUtil.getKey(token);
		return usuarioId != null;
	}
}
