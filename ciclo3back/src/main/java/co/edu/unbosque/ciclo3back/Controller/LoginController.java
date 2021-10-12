package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.edu.unbosque.ciclo3back.dao.UsuarioDAO;
import co.edu.unbosque.ciclo3back.model.Login;
import co.edu.unbosque.ciclo3back.model.Usuario;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Controller
public class LoginController {

	@Autowired
	private UsuarioDAO usuarioDao;

	@Autowired
	private JWTUtil jwtUtil;

	public String verificarCredenciales(Login pUsuario) {
		try {
			List<Usuario> list = usuarioDao.findAll();
			Usuario credenciales = null;
			boolean cen = false;
			for (int i = 0; i < list.size() && !cen; i++) {
				if (pUsuario.getUsuario().equals(list.get(i).getUsuario())) {
					credenciales = list.get(i);
					cen = true;
				}
			}
			if (credenciales == null)
				return "No existe el usuario";
			Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			if (argon2.verify(credenciales.getPassword(), pUsuario.getPassword())) {
				String jwtToken = jwtUtil.create(String.valueOf(credenciales.getCedula_usuario()),
						credenciales.getEmail_usuario());
				return jwtToken;
			} else {
				return "Credenciales Incorrectas";
			}
		} catch (Exception e) {
			System.err.println("Error: No funciono jeje");
			return null;
		}
	}
}
